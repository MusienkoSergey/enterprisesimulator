package ua.ck.codenvy.simulator.client;//package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import javax.ws.rs.core.MediaType;

/**
* Created by sergey on 28.04.14.
*/
public class GeneratorEmployees implements EntryPoint {
    private FlexTable employeesFlexTable = new FlexTable();
    private String type;

    static {
        Defaults.setDateFormat(MediaType.TEXT_PLAIN);
    }
    @Override
    public void onModuleLoad() {
        Button button1 = new Button("start");
        button1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                type = "One";
                startGenerator();

            }
        });
        Button button2 = new Button("start");
        button2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                type = "Two";
                startGenerator();
            }
        });

        employeesFlexTable.setText(0, 0, "create a employees through the generator 1");
        employeesFlexTable.setWidget(0, 1, button1);
        employeesFlexTable.setText(1, 0, "create a employees through the generator 2");
        employeesFlexTable.setWidget(1, 1, button2);

        RootPanel.get("generatorList").add(employeesFlexTable);


    }
   void startGenerator() {
       CreatorGeneratorAsync.Util.get(type).choiceOfGenerator(
               new MethodCallback<Void>() {
                   public void onFailure(Method method, Throwable caught) {
                       Window.alert("no connection");
                   }
                   public void onSuccess(Method method, Void aVoid) {
                       String message;
                       if(type.equals("One")) {
                           message = "Generated up to ten employees";
                       } else if(type.equals("Two")) {
                           message = "Generated up to five employees";
                       } else {
                           message = "Generated null employees";
                       }
                       Window.alert(message);
                   }
               });
   }
}
