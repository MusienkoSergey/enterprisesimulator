package ua.ck.codenvy.simulator.dao;

/**
 * Created by sergey on 17.03.14.
 */
public class Factory {
    private static CompanyDao companyDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public CompanyDao getCompanyDao() {
        if (companyDao == null) {
            companyDao = new CompanyDao();
        }
        return companyDao;
    }
}

