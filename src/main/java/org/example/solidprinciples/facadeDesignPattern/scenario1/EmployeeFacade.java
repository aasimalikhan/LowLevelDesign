package org.example.solidprinciples.facadeDesignPattern.scenario1;

public class EmployeeFacade {
    EmployeeDAO employeeDAO;
    public EmployeeFacade(){
        employeeDAO = new EmployeeDAO();
    }
    public void insert(){
        employeeDAO.insert();
    }
    public Employee getEmployeeDetails(int empId){
        return employeeDAO.getEmployeeDetails(empId);
    }
}
