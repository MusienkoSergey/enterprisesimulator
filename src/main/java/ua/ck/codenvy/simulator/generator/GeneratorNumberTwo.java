package ua.ck.codenvy.simulator.generator;//package ua.ck.codenvy.simulator.generator;

import ua.ck.codenvy.simulator.entity.EmployeeFactory;
import ua.ck.codenvy.simulator.entity.TypeEmployee;
import ua.ck.codenvy.simulator.shared.Employee;
import ua.ck.codenvy.simulator.shared.EmployeeWithFixedSalary;
import ua.ck.codenvy.simulator.shared.EmployeeWithHourlyWages;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* Created by sergey on 08.04.14.
*/
public class GeneratorNumberTwo implements Generator {

    private List<Employee> empl = null;

    @Override
    public List<Employee> start () {

        empl = new ArrayList<Employee>();
        Random rand = new Random();
        int number = rand.nextInt(4)+1;

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
                12.77,
        };

        for(int i = 0; i < number; i++) {
            EmployeeFactory employeeFactory = new EmployeeFactory();
            if ((i % 2) == 1) {
                empl.add(i, employeeFactory.CreateEmployee(TypeEmployee.EMPLOYEE_WITH_FIXED_SALARY));
                ((EmployeeWithFixedSalary)empl.get(i)).solveSalary(fixSalary[rand.nextInt(fixSalary.length)]);
            } else {
                empl.add(i, employeeFactory.CreateEmployee(TypeEmployee.EMPLOYEE_WITH_HOURLY_WAGES));
                ((EmployeeWithHourlyWages)empl.get(i)).solveSalary(hSalary[rand.nextInt(hSalary.length)]);
            }
            empl.get(i).setSurname(name[rand.nextInt(name.length)]);
            empl.get(i).setDateOfBirth(date[rand.nextInt(date.length)]);
        }
        return empl;
    }
}
