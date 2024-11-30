package org.example.designScenarios.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.TransactionType;
import org.example.designScenarios.designATM.state.ATMState;

public class SelectOperationState extends ATMState {
    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        switch (txnType)
        {
            case BALANCE_INQUIRY -> {
                SingletonLogger.getInstance().log(1, "Transaction type : CHECK BALANCE");
                atm.setCurrentATMState(new CheckBalanceState());
            }
            case CASH_WITHDRAWAL -> {
                SingletonLogger.getInstance().log(1, "Transaction type : CASH WITHDRAWAL");
                atm.setCurrentATMState(new CashWithdrawalState());
            }
        }
    }
}
