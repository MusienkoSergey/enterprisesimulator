package ua.ck.codenvy.simulator.client;//package ua.ck.codenvy.simulator.client;

import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.RestServiceProxy;

import javax.ws.rs.POST;

/**
* Created by sergey on 28.04.14.
*/

public interface CreatorGeneratorAsync extends RestService {

    @POST
    void choiceOfGenerator(MethodCallback<Void> callback);

    public static final class Util {

        private static CreatorGeneratorAsync instance;

        public static final CreatorGeneratorAsync get(String type) {
                instance = GWT.create(CreatorGeneratorAsync.class);
                ((RestServiceProxy) instance).setResource(new Resource(
                        "rest/generator").addQueryParam("type", type));
            return instance;
        }

        private Util() {
            // Utility class should not be instantiated
        }

    }
}