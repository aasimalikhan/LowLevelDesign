package org.example.caseStudies.designATM;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, "1120");
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
    }
    private BankAccount createBankAccount() {
        return new BankAccount(3000, null);
    }
    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }
    private User createUser()
    {
        User user = new User();
        user.setCard(createCard());
        return user;
    }
    private void initialize() {
        atm = new ATM();
        atm.setAtmBalance(3500, 1, 2, 5);
        this.user = createUser();
    }
}
