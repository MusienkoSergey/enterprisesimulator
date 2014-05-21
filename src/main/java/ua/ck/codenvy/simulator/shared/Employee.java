package ua.ck.codenvy.simulator.shared;

import java.sql.Date;

/**
 * Created by sergey on 16.03.14.
 */

public abstract class Employee {

    private int id;

    private String surname;

    private Date dateOfBirth;

    private double salary;

    protected Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
