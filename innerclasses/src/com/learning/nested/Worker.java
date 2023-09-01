package com.learning.nested;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

record Employee (String firstName, String lastName, String hireDate){}

public class Worker {

    public static void main(String[] args) throws ParseException {

        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee("Bubai", "Bal", "14-10-1986"),
                new Employee("Soma", "Bal", "14-10-1986"),
                new Employee("Sayam", "Moitra", "14-10-1986")
        ));

        

    }

    private static void showDetails(List<Employee> employeeList) {

        class EmployeeWrapper {

            Employee employee;
            String fullName;
            int yearsWorked;

            public EmployeeWrapper(Employee employee) {
                this.employee = employee;
                this.fullName = "%s %s".formatted(employee.firstName(), employee.lastName());
                this.yearsWorked = LocalDate.now().getYear() - LocalDate.parse(employee.hireDate()).getYear();
            }
        }
    }
}
