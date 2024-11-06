package org.example.proxyDesignPattern.code;

public class EmployeeDAOProxy implements EmployeeDAO{
    EmployeeDAO employeeDAOObj;
    EmployeeDAOProxy()
    {
        employeeDAOObj = new EmployeeDAOImpl();
    }
    @Override
    public void create(String client, EmployeeDO obj) throws Exception {
        if(client.equals("ADMIN"))
        {
            employeeDAOObj.create(client, obj);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN"))
        {
            employeeDAOObj.delete(client, employeeId);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public EmployeeDO get(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN") || client.equals("USER"))
        {
            return employeeDAOObj.get(client, employeeId);
        }
        throw new Exception("Access denied");
    }
}
