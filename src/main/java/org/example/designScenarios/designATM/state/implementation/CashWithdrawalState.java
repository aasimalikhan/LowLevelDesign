package org.example.designScenarios.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.designScenarios.designATM.ATM;
import org.example.designScenarios.designATM.AmountWithdrawal.CashWithdrawProcessor;
import org.example.designScenarios.designATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import org.example.designScenarios.designATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import org.example.designScenarios.designATM.AmountWithdrawal.TwoThousandWithdrawProcessor;
import org.example.designScenarios.designATM.Card;
import org.example.designScenarios.designATM.state.ATMState;

public class CashWithdrawalState extends ATMState {
    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount)
    {
        if(atm.getAtmBalance() < withdrawAmount)
        {
            SingletonLogger.getInstance().log(3, "Insufficient fund in the ATM machine!");
            exit(atm);
        }
        else if(card.getBalance() < withdrawAmount)
        {
            SingletonLogger.getInstance().log(3, "Insufficient fund in your Bank Account!");
        }
        else {
            card.deductBankBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);
            CashWithdrawProcessor withdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withdrawProcessor.withdraw(atm, withdrawAmount);
            SingletonLogger.getInstance().log(1, "Transaction successful!");
            exit(atm);
        }
    }
}
