package org.example.designScenarios.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.BankAccount;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.state.ATMState;
import org.example.designScenarios.designVehicleRentalManagementSystem.models.User;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card)
    {
        SingletonLogger.getInstance().log(1, "ATM card inserted!");
        atm.setCurrentATMState(new HasCardState());
    }
}
