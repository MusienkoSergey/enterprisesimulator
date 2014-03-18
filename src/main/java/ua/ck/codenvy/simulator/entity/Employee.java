package ua.ck.codenvy.simulator.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sergey on 16.03.14.
 */
@Entity
@Table(name = "Employee")
public abstract class Employee {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "salary")
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
