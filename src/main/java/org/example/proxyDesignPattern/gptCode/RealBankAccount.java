package org.example.proxyDesignPattern.gptCode;

public class RealBankAccount implements BankAccount{
    private double balance;
    public RealBankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
