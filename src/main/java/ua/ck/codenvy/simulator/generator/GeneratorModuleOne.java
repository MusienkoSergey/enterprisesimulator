package ua.ck.codenvy.simulator.generator;

import com.google.inject.AbstractModule;

/**
 * Created by sergey on 08.04.14.
 */
public class GeneratorModuleOne extends AbstractModule {

    @Override
    protected void configure() {
        bind(Generator.class).to(GeneratorNumberOne.class);
    }
}
