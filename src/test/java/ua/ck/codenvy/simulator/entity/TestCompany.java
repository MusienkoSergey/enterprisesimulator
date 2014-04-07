package ua.ck.codenvy.simulator.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sergey on 07.04.14.
 */
public class TestCompany {

    private Company firstCompany = null;
    private Company secondCompany = null;

    @Test
    public void testCompanySingleton() {
        firstCompany = Company.getInstance();
        secondCompany = Company.getInstance();
        Assert.assertTrue(firstCompany == secondCompany);
    }

}
