package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.RestServiceProxy;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

/**
 * Created by sergey on 29.04.14.
 */
public interface DbManagerAsync extends RestService {

    @GET
    void getAllEmployees(MethodCallback<List<ClientEmployee>> callback);

    @DELETE
    void removeEmployees(MethodCallback<Void> callback);

    @POST
    void sortingEmployees(MethodCallback<List<ClientEmployee>> callback);

    public static final class Util {

        private static DbManagerAsync instance;
        private static DbManagerAsync instance1;
        private static DbManagerAsync instance3;

        public static final DbManagerAsync get() {
            if (instance == null) {
                instance = GWT.create(DbManagerAsync.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "rest/manager"));
            }
            return instance;
        }

        public static final DbManagerAsync delete(String id) {
                instance1 = GWT.create(DbManagerAsync.class);
                ((RestServiceProxy) instance1).setResource(new Resource(
                        "rest/manager").addQueryParam("id", id));

            return instance1;
        }

        public static final DbManagerAsync update(String buttonName) {
            instance3 = GWT.create(DbManagerAsync.class);
            ((RestServiceProxy) instance3).setResource(new Resource(
                    "rest/manager").addQueryParam("buttonName", buttonName));
            return instance3;
        }

        private Util() {
            // Utility class should not be instantiated
        }

    }


}
