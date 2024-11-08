package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Item;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.State;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.VendingMachine;

import java.util.List;

public class DispenseState implements State {
    @Override
    public void chooseItems(VendingMachine machine, List<Item> items) throws Exception {
        throw new Exception("You have already selected items");
    }

    @Override
    public void payMoney(VendingMachine machine, double amount) throws Exception {
        throw new Exception("Payment already done");
    }

    @Override
    public void refundMoney(VendingMachine machine, double amount) throws Exception {

    }

    @Override
    public void dispenseItem(VendingMachine machine, List<Item> items) throws Exception {
        System.out.println("Dispensing items");
        for(Item item: items)
        {
            System.out.println("Item " + item.getItemCode() + ", quantity: " + item.getQuantity() + " dispensed");
            Item inventoryItem = machine.getInventory().getItem(item.getItemCode());
            machine.getInventory().updateItemQuantity(inventoryItem.getItemCode(), inventoryItem.getQuantity() - item.getQuantity());
        }
    }
}