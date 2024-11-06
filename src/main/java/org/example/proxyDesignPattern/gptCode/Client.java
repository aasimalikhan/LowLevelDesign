package org.example.proxyDesignPattern.gptCode;

public class Client {
    public static void main(String[] args) {
        BankAccount account = new BankAccountProxy(1000.0, "secure123");
        System.out.println("Trying to withdraw 300...");
        account.withdraw(300);
        System.out.println("Checking balance: " + account.getBalance());

        // Attempt to withdraw with wrong password
        System.out.println("Trying to withdraw 800 with incorrect password...");
        account.withdraw(800);

    }
}
