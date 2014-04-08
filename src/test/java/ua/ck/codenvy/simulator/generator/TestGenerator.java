package ua.ck.codenvy.simulator.generator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
* Created by sergey on 23.03.14.
*/
public class TestGenerator {
    Generator generator = null;

    @Before
    public void testStartInit() {
        generator = new GeneratorNumberOne();
    }

    @Test
    public void testStart() {
        for (int i = 0; i < 10; i++){
            assertTrue(generator.start().size() >= 1 && generator.start().size() <= 10);
        }
    }

    @Test
    public void testStartNotNull() {
        for (int i = 0; i < 100; i++){
            assertNotNull(generator.start());
        }
    }

    @After
    public void testStartDestruction() {
        generator = null;
    }

}
