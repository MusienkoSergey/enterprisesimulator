package ua.ck.codenvy.simulator.generator;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by sergey on 08.04.14.
 */
public class GeneratorModuleTwo extends AbstractModule {

    @Override
    protected void configure() {
        bind(Generator.class).to(GeneratorNumberTwo.class).in(Singleton.class);
    }
}

