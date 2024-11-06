package org.example.proxyDesignPattern.gptCode;

public class BankAccountProxy implements BankAccount{
    private RealBankAccount realBankAccount;
    private String password;
    public BankAccountProxy(double initialBalance, String password)
    {
        this.realBankAccount = new RealBankAccount(initialBalance);
        this.password = password;
    }

    private boolean authenticate(String inputPassword)
    {
        return this.password.equals(inputPassword);
    }
    @Override
    public void withdraw(double amount) {
        if (authenticate(getUserPassword())) {
            realBankAccount.withdraw(amount);
        } else {
            System.out.println("Authentication failed: Access denied.");
        }
    }

    @Override
    public double getBalance() {
        if (authenticate(getUserPassword())) {
            return realBankAccount.getBalance();
        } else {
            System.out.println("Authentication failed: Access denied.");
            return -1;
        }
    }

    private String getUserPassword() {
        // In a real application, this would be an input from the user.
        // For simplicity, let's assume the correct password is "secure123".
        return "secure123"; // Simulated correct password
    }
}
