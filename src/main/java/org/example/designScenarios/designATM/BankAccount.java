package org.example.designScenarios.designATM;

import java.util.List;

public class BankAccount {
    private static int idCounter = 101;

    private String number;
    private List<Card> cards;
    private float balance;

    public BankAccount(float balance, List<Card> cards)
    {
        this.number = String.valueOf(idCounter++);
        this.balance = balance;
        this.cards = cards;
    }

    public void withdrawBalance(int amount)
    {
        balance = balance - amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
