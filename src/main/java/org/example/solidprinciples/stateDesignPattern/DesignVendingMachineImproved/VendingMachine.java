package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved;

import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.Implementation.IdleState;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.State;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Payment.PaymentProcessor;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Payment.UpiPaymentProcessor;

public class VendingMachine {
    private Inventory inventory;
    private PaymentProcessor paymentProcessor;
    private State machineState;

    public State getMachineState() {
        return machineState;
    }

    public void setMachineState(State machineState) {
        this.machineState = machineState;
    }

    public VendingMachine() {
        machineState = new IdleState();
        inventory = new Inventory();
        paymentProcessor = new UpiPaymentProcessor();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
}