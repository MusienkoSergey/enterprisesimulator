package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Created by sergey on 28.04.14.
 */
public class GeneratorEmployees implements EntryPoint {
    private FlexTable employeesFlexTable = new FlexTable();
    private CreatorGeneratorAsync creatorGenerator;
    private int type;
    public void onModuleLoad() {
        Button button1 = new Button("start");
        button1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                type = 1;
                startGenerator(type);

            }
        });
        Button button2 = new Button("start");
        button2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                type = 2;
                startGenerator(type);
            }
        });

        employeesFlexTable.setText(0, 0, "create a employees through the generator 1");
        employeesFlexTable.setWidget(0, 1, button1);
        employeesFlexTable.setText(1, 0, "create a employees through the generator 2");
        employeesFlexTable.setWidget(1, 1, button2);

        RootPanel.get("generatorList").add(employeesFlexTable);


    }
   void startGenerator(int type) {
       if (creatorGenerator == null) {
           creatorGenerator = GWT.create(CreatorGenerator.class);
       }

       AsyncCallback<String> callback = new AsyncCallback<String>() {
           public void onFailure(Throwable caught) {
               Window.alert("no connection");
           }

           public void onSuccess(String result) {
               Window.alert(result);
           }
       };
       //Launches a particular type generator
       creatorGenerator.choiceOfGenerator(type, callback);
   }
}
