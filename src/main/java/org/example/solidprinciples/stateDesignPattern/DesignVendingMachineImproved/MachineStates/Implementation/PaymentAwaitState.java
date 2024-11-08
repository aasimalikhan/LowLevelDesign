package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Item;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.State;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.VendingMachine;

import java.util.List;

public class PaymentAwaitState implements State {
    public PaymentAwaitState() {
        System.out.println("Awaiting for Payment");
    }

    @Override
    public void chooseItems(VendingMachine machine, List<Item> items) throws Exception {
        throw new Exception("You have already selected items");
    }

    @Override
    public void payMoney(VendingMachine machine, double amount) throws Exception {
        machine.getPaymentProcessor().processPayment(amount);
        machine.setMachineState(new DispenseState());
    }

    @Override
    public void refundMoney(VendingMachine machine, double amount) throws Exception {
        throw new Exception("You have not made any transaction");
    }

    @Override
    public void dispenseItem(VendingMachine machine, List<Item> items) throws Exception {
        throw new Exception("You have not purchased any items");
    }
}
