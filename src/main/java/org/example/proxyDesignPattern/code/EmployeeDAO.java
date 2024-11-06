package org.example.proxyDesignPattern.code;

public interface EmployeeDAO {
    public void create(String client, EmployeeDO obj) throws Exception;
    public void delete(String client, int employeeId) throws Exception;
    public EmployeeDO get(String client, int employeeId) throws Exception;
}
