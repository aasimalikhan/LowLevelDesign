package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved;

import java.util.ArrayList;
import java.util.List;

public class DesignVendingMachineImproved {

    public static void displayInventory(VendingMachine vendingMachine)
    {
        for(Item item : vendingMachine.getInventory().getInventory())
        {
            System.out.println("item code: " + item.getItemCode());
            System.out.println("item name: " + item.getName());
            System.out.println("item description: " + item.getDescription());
            System.out.println("item price: " + item.getPrice());
            System.out.println("item quantity availabkle: " + item.getQuantity());
            System.out.println(" ------------------------------------ ");
        }
    }

    public static void displayItemsToBePurchased(List<Item> items)
    {
        for(Item item : items)
        {
            System.out.println("item code: " + item.getItemCode());
            System.out.println("item name: " + item.getName());
            System.out.println("item description: " + item.getDescription());
            System.out.println("item price: " + item.getPrice());
            System.out.println("item quantity availabkle: " + item.getQuantity());
            System.out.println(" ------------------------------------ ");
        }
    }
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            Item item1 = new Item();
            item1.setPrice(20);
            item1.setName("Cola cola 200ml can");
            item1.setDescription("Cola cola 200ml metal can contains caffeine");
            Item item2 = new Item();
            item2.setPrice(30);
            item2.setName("Sprite 200ml can");
            item2.setDescription("Sprite 200ml metal can contains caffeine");
            Item item3 = new Item();
            item3.setPrice(45);
            item3.setName("Kurkure green chutney 100gm");
            item3.setDescription("Kurkure green chutney flavour 100gm value pack");
            Item item4 = new Item();
            item4.setPrice(25);
            item4.setName("britannia jim jam 50gm");
            item4.setDescription("Britannia jim jam 50gm classic pack");

            vendingMachine.getInventory().addItem(null, "101");

            vendingMachine.getInventory().addItem(item1, "201");
            vendingMachine.getInventory().addItem(item1, "201");
            vendingMachine.getInventory().addItem(item2, "202");
            vendingMachine.getInventory().addItem(item3, "203");
            vendingMachine.getInventory().addItem(item4, "204");

            System.out.println("||||||");
            System.out.println("Current Inventory: ");
            displayInventory(vendingMachine);

            System.out.println("Choosing Items");
            Item itemChose1 = new Item();
            itemChose1.setItemCode("201");
            itemChose1.setQuantity(2);

            Item itemChose2 = new Item();
            itemChose2.setItemCode("202");
            itemChose2.setQuantity(1);

            List<Item> itemsToBePurchased = new ArrayList<>();
            itemsToBePurchased.add(itemChose1);
            itemsToBePurchased.add(itemChose2);

            displayItemsToBePurchased(itemsToBePurchased);
            vendingMachine.getMachineState().chooseItems(vendingMachine, itemsToBePurchased);

            double totalItemPrice = 0;
            for(Item item : itemsToBePurchased)
            {
                totalItemPrice += vendingMachine.getInventory().getItem(item.getItemCode()).getPrice();
            }
            System.out.println("Total items price: " + totalItemPrice);
            vendingMachine.getMachineState().payMoney(vendingMachine, totalItemPrice);
            Thread.sleep(2000);
            vendingMachine.getMachineState().dispenseItem(vendingMachine, itemsToBePurchased);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}