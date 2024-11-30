package org.example.designScenarios.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.state.ATMState;

public class CheckBalanceState extends ATMState
{
    @Override
    public void displayBalance(ATM atm, Card card){
        SingletonLogger.getInstance().log(1, "Your Balance is: " + card.getBalance());
        exit(atm);
    }

}
