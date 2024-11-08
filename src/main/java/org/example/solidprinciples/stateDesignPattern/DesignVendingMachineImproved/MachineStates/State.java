package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates;

import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Item;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.VendingMachine;

import java.util.List;

public interface State {
    public void chooseItems(VendingMachine machine, List<Item> items) throws Exception;
    public void payMoney(VendingMachine machine, double amount) throws Exception;
    public void refundMoney(VendingMachine machine, double amount) throws Exception;
    public void dispenseItem(VendingMachine machine, List<Item> items) throws Exception;
}
