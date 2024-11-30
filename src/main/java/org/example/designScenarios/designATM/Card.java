package org.example.designScenarios.designATM;

import java.util.Objects;

public class Card {
    private String number;
    private String CVV;
    private int expiryDate;
    private int holderName;
    static String PIN_NUMBER = "1120";
    private BankAccount bankAccount;
    public boolean isCorrectPINEntered(String pin) {
        return Objects.equals(pin, PIN_NUMBER);
    }
    public float getBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawBalance(amount);
    }
    public void setBankAccount(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
}
