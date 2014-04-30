package ua.ck.codenvy.simulator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by sergey on 28.04.14.
 */
@RemoteServiceRelativePath("creatorGenerator")
public interface CreatorGenerator extends RemoteService {
    String choiceOfGenerator(int i);
}
