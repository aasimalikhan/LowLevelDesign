package org.example.caseStudies.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.caseStudies.designATM.ATM;
import org.example.caseStudies.designATM.Card;
import org.example.caseStudies.designATM.state.ATMState;

public class CheckBalanceState extends ATMState
{
    @Override
    public void displayBalance(ATM atm, Card card){
        SingletonLogger.getInstance().log(1, "Your Balance is: " + card.getBalance());
        exit(atm);
    }

}
