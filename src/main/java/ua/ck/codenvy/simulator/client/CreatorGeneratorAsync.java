package ua.ck.codenvy.simulator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by sergey on 28.04.14.
 */
public interface CreatorGeneratorAsync {
    void choiceOfGenerator(int i, AsyncCallback<String> callback);
}
