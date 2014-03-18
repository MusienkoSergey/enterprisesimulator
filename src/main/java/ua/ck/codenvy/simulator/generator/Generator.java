package ua.ck.codenvy.simulator.generator;

import ua.ck.codenvy.simulator.entity.Employee;
import ua.ck.codenvy.simulator.entity.EmployeeWithFixedSalary;
import ua.ck.codenvy.simulator.entity.EmployeeWithHourlyWages;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sergey on 17.03.14.
 */
public class Generator {

    private List<Employee> Empl = new ArrayList<Employee>();

    public List<Employee> start () {

        Random rand = new Random();
        int namber = rand.nextInt(9)+1;

        String[] name = {
                "Alexandrov",
                "Petrov",
                "Ivanov",
                "Sidorov",
                "Gagarin",
                "Nemzov",
                "Musienko",
                "Shevchenko",
                "Petrenko",
                "Zaharov"
        };

        Date[] date = {
                Date.valueOf("1999-01-11"),
                Date.valueOf("1998-02-22"),
                Date.valueOf("1997-01-23"),
                Date.valueOf("1996-09-21"),
                Date.valueOf("1995-02-03"),
                Date.valueOf("1998-07-20"),
                Date.valueOf("1995-08-29"),
                Date.valueOf("2000-04-04"),
                Date.valueOf("1999-03-16"),
                Date.valueOf("1989-02-06"),
        };

        double[] fixSalary = {
                1200,
                1333,
                1999.99,
                200,
                2500,
                1700.30,
                1500.5,
                1030.43,
                1999.01,
                1236.77
        };

        double[] hSalary = {
                15,
                13.8,
                20,
                11,
                7,
                16,
                15.5,
                10.43,
                19.01,
                12,77
        };

    for(int i = 0; i < namber; i++) {
        if ((i % 2) == 1) {

            Empl.add(i, new EmployeeWithFixedSalary());
            Empl.get(i).setSalary(fixSalary[rand.nextInt(fixSalary.length)]);
        }
        else {
            Empl.add(i, new EmployeeWithHourlyWages());
            ((EmployeeWithHourlyWages)Empl.get(i)).solveSalary(hSalary[rand.nextInt(hSalary.length)]);
        }
        Empl.get(i).setSurname(name[rand.nextInt(name.length)]);
        Empl.get(i).setDateOfBirth(date[rand.nextInt(date.length)]);
    }
        return Empl;
    }
}
