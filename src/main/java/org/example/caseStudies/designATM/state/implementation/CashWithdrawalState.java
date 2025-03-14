package org.example.caseStudies.designATM.state.implementation;

import org.example.UTILS_CODE.logger.SingletonLogger;
import org.example.caseStudies.designATM.ATM;
import org.example.caseStudies.designATM.AmountWithdrawal.CashWithdrawProcessor;
import org.example.caseStudies.designATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import org.example.caseStudies.designATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import org.example.caseStudies.designATM.AmountWithdrawal.TwoThousandWithdrawProcessor;
import org.example.caseStudies.designATM.Card;
import org.example.caseStudies.designATM.state.ATMState;

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
