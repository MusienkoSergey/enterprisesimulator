package ua.ck.codenvy.simulator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by sergey on 29.04.14.
 */
public interface DbManagerAsync {
    void getAllEmployees(AsyncCallback<List<Employee>> async);
    void removeEmployees(long id, AsyncCallback<Void> async);
}
