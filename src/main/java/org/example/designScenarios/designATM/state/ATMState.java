package org.example.designScenarios.designATM.state;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.TransactionType;
import org.example.designScenarios.designATM.state.implementation.IdleState;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card)
    {
        System.out.println("OOPS! Something went wrong!");
    }
    public void authenticatePin(ATM atm, Card card, String pin)
    {
        System.out.println("OOPS! Something went wrong!");
    }
    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        System.out.println("OOPS! Something went wrong!");
    }
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount)
    {
        System.out.println("OOPS! Something went wrong!");
    }
    public void displayBalance(ATM atm, Card card)
    {
        System.out.println("OOPS! Something went wrong!");
    }
    public void returnCard()
    {
        SingletonLogger.getInstance().log(1, "Please collect your card!");
    }
    public void exit(ATM atm)
    {
        SingletonLogger.getInstance().log(1, "Transaction completed!");
        returnCard();
        atm.setCurrentATMState(new IdleState());
    }

}
