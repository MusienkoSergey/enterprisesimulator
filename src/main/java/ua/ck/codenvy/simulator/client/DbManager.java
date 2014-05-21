package ua.ck.codenvy.simulator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by sergey on 29.04.14.
 */
@RemoteServiceRelativePath("dbManager")
public interface DbManager extends RemoteService {
    List<Employee> getAllEmployees();
    void removeEmployees(long id);
}
