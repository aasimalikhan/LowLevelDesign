package org.example.solidprinciples.proxyDesignPattern.code;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public void create(String client, EmployeeDO obj) throws Exception {
        System.out.println("created new row in the Employee table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("deleted row with employeeId: " + employeeId);
    }

    @Override
    public EmployeeDO get(String client, int employeeId) throws Exception {
        System.out.println("fetching data from the DB");
        return new EmployeeDO();
    }
}
