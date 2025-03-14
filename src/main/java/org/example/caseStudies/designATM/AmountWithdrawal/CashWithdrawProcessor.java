package org.example.caseStudies.designATM.AmountWithdrawal;

import org.example.caseStudies.designATM.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor)
    {
        this.nextCashWithdrawProcessor = cashWithdrawProcessor;
    }
    public void withdraw(ATM atm, int remainingAmount)
    {
        if(nextCashWithdrawProcessor != null)
        {
            nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}
