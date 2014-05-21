package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

/**
 * Created by sergey on 28.04.14.
 */
public class ManagementEmployees implements EntryPoint {
    private FlexTable employeesFlexTable = new FlexTable();
    private VerticalPanel mainVerticalPanel = new VerticalPanel();
    private DbManagerAsync dbManagerAsync;
    public void onModuleLoad() {
        //Title employees table
        employeesFlexTable.setText(0, 0, "Id");
        employeesFlexTable.setText(0, 1, "Surname");
        employeesFlexTable.setText(0, 2, "Data of Birth");
        employeesFlexTable.setText(0, 3, "Salary");
        employeesFlexTable.setText(0, 4, "Remove");
        getEmployees();
        mainVerticalPanel.add(employeesFlexTable);
        // Add the main panel to the HTML element with the ID "employeesList"
        RootPanel.get("employeesList").add(mainVerticalPanel);

    }

    //Gets a collection of employees from the server
    private void getEmployees() {
        if (dbManagerAsync == null) {
            dbManagerAsync = GWT.create(DbManager.class);
        }
        AsyncCallback<List<Employee>> callback = new AsyncCallback<List<Employee>>() {
            public void onFailure(Throwable caught) {
                Window.alert("no connection" + caught.toString());
            }

            public void onSuccess(List<Employee> employees) {
                printEmployees(employees);
            }
        };
        dbManagerAsync.getAllEmployees(callback);
    }

    //Сreates a table employees
    private void printEmployees(List<Employee> employees){
        for(Employee employee: employees){
            // add the employees to the list
            int row = employeesFlexTable.getRowCount();
            employeesFlexTable.setText(row, 0, String.valueOf(employee.getId()));
            employeesFlexTable.setText(row, 1, employee.getSurname());
            employeesFlexTable.setText(row, 2, employee.getDateOfBirth().toString());
            employeesFlexTable.setText(row, 3, String.valueOf(employee.getSalary()));


            Button removeEmployee = new Button("x");

            final int line = row;

            removeEmployee.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    if (dbManagerAsync == null) {
                        dbManagerAsync = GWT.create(DbManager.class);
                    }
                    AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                        public void onFailure(Throwable caught) {
                            Window.alert("no connection" + caught.toString());
                        }

                        public void onSuccess(Void v) {
                            Window.alert("removed");
                            employeesFlexTable.removeAllRows();
                            getEmployees();

                        }
                    };
                    //Removes employee
                    dbManagerAsync.removeEmployees(Integer.parseInt(employeesFlexTable.getText(line, 0)), callback);
                }
            });
            // add button to remove this employee from the list
            employeesFlexTable.setWidget(row, 4, removeEmployee);
        }
    }
}
