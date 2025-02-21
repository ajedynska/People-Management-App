package controller;

import bwz.models.Employee;
import bwz.models.EmployeeModel;

import java.util.List;

public class EmployeeController {

    private EmployeeModel employeeModel;

    public EmployeeController() {
        employeeModel = new EmployeeModel();
        employeeModel.loadEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeModel.addEmployee(employee);
    }

    public void updateEmployee(int index, Employee employee) {
        employeeModel.updateEmployee(index, employee);
    }

    public Employee getEmployee(int index) {
        return employeeModel.getEmployee(index);
    }

    public void deleteEmployee(int index) {
        employeeModel.deleteEmployee(index);
    }

    public List<Employee> getEmployees() {
        return  employeeModel.getEmployees();
    }

    public void saveEmployees() {
        employeeModel.saveEmployees();
    }
}
