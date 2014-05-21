package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

/**
 * Created by sergey on 28.04.14.
 */
public class ManagementEmployees implements EntryPoint {
    private FlexTable employeesFlexTable = new FlexTable();
    private VerticalPanel mainVerticalPanel = new VerticalPanel();

    static {
        Defaults.setDateFormat(null);
    }
    @Override
    public void onModuleLoad() {
        getEmployees();
        // Add the main panel to the HTML element with the ID "employeesList"
        RootPanel.get("employeesList").add(mainVerticalPanel);
    }

    //Gets a collection of employees from the server
    private void getEmployees() {
        DbManagerAsync.Util.get().getAllEmployees(new MethodCallback<List<ClientEmployee>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("no connection" + throwable.toString());
            }
            @Override
            public void onSuccess(Method method, List<ClientEmployee> employees) {
                printEmployees(employees);
            }
        });
    }

    //Сreates a table employees
    private void printEmployees(List<ClientEmployee> employees) {
        employeesFlexTable.removeAllRows();
           //Title employees table
        employeesFlexTable.setWidget(0, 0, buttonService("Id"));
        employeesFlexTable.setWidget(0, 1, buttonService("Surname"));
        employeesFlexTable.setWidget(0, 2, buttonService("Data of Birth"));
        employeesFlexTable.setWidget(0, 3, buttonService("Salary"));
        employeesFlexTable.setWidget(0, 4, buttonService("Remove"));
        mainVerticalPanel.add(employeesFlexTable);

        for(ClientEmployee employee: employees) {
            // add the employees to the list
            int row = employeesFlexTable.getRowCount();
            employeesFlexTable.setText(row, 0, String.valueOf(employee.getId()));
            employeesFlexTable.setText(row, 1, employee.getSurname());
            employeesFlexTable.setText(row, 2, employee.getDateOfBirth());
            employeesFlexTable.setText(row, 3, String.valueOf(employee.getSalary()));

            Button removeEmployee = new Button("x");
            final int line = row;
            removeEmployee.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    DbManagerAsync.Util.delete(employeesFlexTable.getText(line, 0)).removeEmployees(
                            new MethodCallback<Void>() {
                                @Override
                                public void onFailure(Method method, Throwable throwable) {
                                    Window.alert("no connection" + throwable.toString());
                                }
                                @Override
                                public void onSuccess(Method method, Void aVoid) {
                                    Window.alert("removed " + employeesFlexTable.getText(line, 1));
                                    employeesFlexTable.removeAllRows();
                                    getEmployees();
                                }
                            });
                }
            });
            // add button to remove this employee from the list
            employeesFlexTable.setWidget(row, 4, removeEmployee);
        }
    }

    private Button buttonService(String buttonName) {
        final Button button = new Button(buttonName);
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                Window.alert(button.getText());

                DbManagerAsync.Util.update(button.getText())
                        .sortingEmployees(new MethodCallback<List<ClientEmployee>>() {
                            @Override
                            public void onFailure(Method method, Throwable throwable) {
                                Window.alert("no connection" + throwable.toString());
                            }

                            @Override
                            public void onSuccess(Method method, List<ClientEmployee> clientEmployees) {
                                printEmployees(clientEmployees);
                            }
                        });
            }
        });
        return button;
    }
}
