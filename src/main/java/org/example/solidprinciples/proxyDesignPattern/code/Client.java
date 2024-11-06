package org.example.solidprinciples.proxyDesignPattern.code;

public class Client {
    public static void main(String[] args) {
        try {
            EmployeeDAO empTableObj = new EmployeeDAOProxy();
            empTableObj.create("ADMIN", new EmployeeDO());
            System.out.println("Operation Successful");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
