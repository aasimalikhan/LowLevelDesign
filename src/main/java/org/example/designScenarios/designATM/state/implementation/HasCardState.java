package org.example.designScenarios.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.state.ATMState;

public class HasCardState extends ATMState {
    public void authenticatePin(ATM atm, Card card, String pin)
    {
        SingletonLogger.getInstance().log(1, "pin entered (static value considered!)");
        if(card.isCorrectPINEntered(pin))
        {
            atm.setCurrentATMState(new SelectOperationState());
        }
        else {
            SingletonLogger.getInstance().log(3, "Wrong pin entered!");
            exit(atm);
        }
    }
}
