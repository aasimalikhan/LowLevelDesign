package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.Implementation;

import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Inventory;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.Item;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.MachineStates.State;
import org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved.VendingMachine;

import java.util.List;

public class IdleState implements State {
    @Override
    public void chooseItems(VendingMachine machine, List<Item> items) throws Exception {
        Inventory inventory = machine.getInventory();
        String itemShortageInfo = "";
        boolean allItemsAvailable = true;
        for(Item item : items)
        {
            if(!inventory.checkItemStock(item.getItemCode(), item.getQuantity()))
            {
                itemShortageInfo += "Only limited quantity of Item: " + item.getItemCode() + "are available.";
                allItemsAvailable = false;
            }
        }
        if(allItemsAvailable)
        {
            machine.setMachineState(new PaymentAwaitState());
        }
        else
        {
            throw new Exception(itemShortageInfo);
        }
    }

    @Override
    public void payMoney(VendingMachine machine, double amount) throws Exception {
        throw new Exception("You need to select items before payment");
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