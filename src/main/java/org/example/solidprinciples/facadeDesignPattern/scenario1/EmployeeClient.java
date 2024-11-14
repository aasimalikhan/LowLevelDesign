package org.example.solidprinciples.facadeDesignPattern.scenario1;

public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        Employee employeeDetails = employeeFacade.getEmployeeDetails(121111);
    }
}
