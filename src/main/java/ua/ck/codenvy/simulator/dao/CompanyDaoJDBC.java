package ua.ck.codenvy.simulator.dao;

import ua.ck.codenvy.simulator.shared.Employee;
import ua.ck.codenvy.simulator.shared.EmployeeWithFixedSalary;
import ua.ck.codenvy.simulator.shared.EmployeeWithHourlyWages;
import ua.ck.codenvy.simulator.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* Created by sergey on 24.03.14.
*/
public class CompanyDaoJDBC {

    public void addEmployee(Employee empl) {
        Connection c = null;
        Class newClass = empl.getClass();
        String typeEmployee = newClass.getSimpleName();
        try {
            c = JDBCConnection.getConnection();
            String sql = "INSERT INTO Employee(date_of_birth, surname, salary, dtype)" +
                    " values (?, ?, ?, ?) ";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setDate(1, empl.getDateOfBirth());
            preparedStatement.setString(2, empl.getSurname());
            preparedStatement.setDouble(3, empl.getSalary());
            preparedStatement.setString(4, typeEmployee);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Employee getEmployeeById(Long id) {
        Connection c = null;
        PreparedStatement ps;
        ResultSet rs;
        Employee empl = null;
        try {
            c = JDBCConnection.getConnection();
            String sql = "SELECT FROM Employee WHERE id = ?";
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("dtype").equals("EmployeeWithHourlyWages")) {
                    empl = new EmployeeWithHourlyWages();
                } else if (rs.getString("dtype").equals("EmployeeWithFixedSalary")) {
                    empl = new EmployeeWithFixedSalary();
                }
                empl.setId(rs.getInt("id"));
                empl.setSurname(rs.getString("surname"));
                empl.setSalary(rs.getDouble("salary"));
                empl.setDateOfBirth(rs.getDate("date_of_birth"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empl;
    }


    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        Connection c = null;
        ResultSet rs;
        try {
            c = JDBCConnection.getConnection();
            rs = c.createStatement().executeQuery("SELECT * FROM  Employee");

            while(rs.next()){
                Employee employee = null;
                if(rs.getString("dtype").equals("EmployeeWithHourlyWages")) {
                    employee = new EmployeeWithHourlyWages();
                } else if (rs.getString("dtype").equals("EmployeeWithFixedSalary")) {
                    employee = new EmployeeWithFixedSalary();
                }
                employee.setId(rs.getInt("id"));
                employee.setSurname(rs.getString("surname"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(rs.getDate("date_of_birth"));
                employees.add(employee);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    public void deleteEmployeeForId(Long id) {
        Connection c = null;
        PreparedStatement ps;
        try {
            c = JDBCConnection.getConnection();
            String sql = "DELETE FROM Employee WHERE id = ?";
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAllEmployee() {
        Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = JDBCConnection.getConnection();
            String sql = "DELETE FROM Employee";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Employee> sortingBySurname() {

        List<Employee> employees = new ArrayList<Employee>();
        Connection c = null;
        ResultSet rs;
        try {
            c = JDBCConnection.getConnection();
            rs = c.createStatement().executeQuery("SELECT * FROM  Employee ORDER by surname");

            while(rs.next()){
                Employee employee = null;
                if(rs.getString("dtype").equals("EmployeeWithHourlyWages")) {
                    employee = new EmployeeWithHourlyWages();
                } else if (rs.getString("dtype").equals("EmployeeWithFixedSalary")) {
                    employee = new EmployeeWithFixedSalary();
                }
                employee.setId(rs.getInt("id"));
                employee.setSurname(rs.getString("surname"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(rs.getDate("date_of_birth"));
                employees.add(employee);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    public List<Employee> sortingBySalary() {

        List<Employee> employees = new ArrayList<Employee>();
        Connection c = null;
        ResultSet rs;
        try {
            c = JDBCConnection.getConnection();
            rs = c.createStatement().executeQuery("SELECT * FROM  Employee ORDER by salary");

            while(rs.next()){
                Employee employee = null;
                if(rs.getString("dtype").equals("EmployeeWithHourlyWages")) {
                    employee = new EmployeeWithHourlyWages();
                } else if (rs.getString("dtype").equals("EmployeeWithFixedSalary")) {
                    employee = new EmployeeWithFixedSalary();
                }
                employee.setId(rs.getInt("id"));
                employee.setSurname(rs.getString("surname"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(rs.getDate("date_of_birth"));
                employees.add(employee);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    public List<Employee> sortingByDateOfBirth() {

        List<Employee> employees = new ArrayList<Employee>();
        Connection c = null;
        ResultSet rs;
        try {
            c = JDBCConnection.getConnection();
            rs = c.createStatement().executeQuery("SELECT * FROM  Employee ORDER by date_of_birth");

            while(rs.next()){
                Employee employee = null;
                if(rs.getString("dtype").equals("EmployeeWithHourlyWages")) {
                    employee = new EmployeeWithHourlyWages();
                } else if (rs.getString("dtype").equals("EmployeeWithFixedSalary")) {
                    employee = new EmployeeWithFixedSalary();
                }
                employee.setId(rs.getInt("id"));
                employee.setSurname(rs.getString("surname"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDateOfBirth(rs.getDate("date_of_birth"));
                employees.add(employee);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }
}