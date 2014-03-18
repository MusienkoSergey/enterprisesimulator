package ua.ck.codenvy.simulator.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import ua.ck.codenvy.simulator.entity.Employee;
import ua.ck.codenvy.simulator.util.HibernateUtil;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergey on 16.03.14.
 */
public class CompanyDao {

    public void addEmployee(Employee empl) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empl);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateEmployee(Employee empl) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empl);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Employee getEmployeeById(Long id) throws SQLException {
        Session session = null;
        Employee empl = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            empl = (Employee) session.load(Employee.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return empl;
    }

    public List<Employee> getAllEmployee() throws SQLException {
        Session session = null;
        List<Employee> empls = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            empls = session.createCriteria(Employee.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return empls;
    }

    public void deleteEmployee(Employee empl) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empl);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteAllEmployee() throws SQLException {
        Session session = null;
        List<Employee> empls;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            empls = session.createCriteria(Employee.class).list();
            for (Employee e: empls) {
                session.delete(e);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Employee> sortingBySurname() throws SQLException {
        Session session = null;
        List<Employee> empls = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            empls = session.createCriteria(Employee.class).addOrder(Order.asc("surname")).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return empls;
    }

    public List<Employee> sortingBySalary() throws SQLException {
        Session session = null;
        List<Employee> empls = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            empls = session.createCriteria(Employee.class).addOrder(Order.asc("salary")).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return empls;
    }

    public List<Employee> sortingByDateOfBirth() throws SQLException {
        Session session = null;
        List<Employee> empls = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            empls = session.createCriteria(Employee.class).addOrder(Order.asc("date_of_birth")).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return empls;
    }
}
