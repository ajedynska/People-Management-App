package model;

import bwz.persistence.PersistenceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    private List<Employee> employees;

    private PersistenceService persistenceService;

    public EmployeeModel() {
        persistenceService = new PersistenceService();
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }

    public Employee getEmployee(int index) {
        return employees.get(index);
    }

    public void updateEmployee(int index, Employee employee) {
        employees.set(index, employee);
        saveEmployees();
    }

    public void deleteEmployee(int index) {
        employees.remove(index);
        saveEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void loadEmployees() {
        //employees = getDefaultEmployees();
        employees = persistenceService.readEmployee();
    }

    public void saveEmployees() {
        persistenceService.saveEmployee(employees);
    }

    private List<Employee> getDefaultEmployees()
    {
        List<Employee> defaultEmployees = new ArrayList<>();

        Employee lara = new Employee(
                "Croft",
                "Lara",
                "Adventurestreet 2",
                "8800",
                "New York",
                "+1 23434234",
                "lara.croft@adv.us",
                LocalDate.of(2001, 03, 14));

        Employee frodo = new Employee(
                "Beutlin",
                "Frodo",
                "Aue 12",
                "99900",
                "Auenland",
                "+99 903333234",
                "frodo.beutlin@auenland.me",
                LocalDate.of(2003, 1, 2));

        Employee gandalf = new Employee(
                "Der Graue",
                "Gandalf",
                "Magierstrasse 99",
                "8888",
                "Towercity",
                "+88 88888888",
                "gandalf.graue@tower.com",
                LocalDate.of(2003, 1, 2));

        defaultEmployees.add(lara);
        defaultEmployees.add(frodo);
        defaultEmployees.add(gandalf);

        return  defaultEmployees;
    }

}
