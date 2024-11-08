package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> inventory = null;

    public Inventory() {
        this.inventory = new ArrayList<>();
        initializeEmptyInventory();
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void initializeEmptyInventory()
    {
        int itemStartCode = 101;
        for (int i = 0; i < 20; i++) {
            String itemCode = String.valueOf(itemStartCode++);
            Item item = ProductNameGenerator.getRandomProductDetail();
            item.setItemCode(itemCode);
            item.setQuantity(2);
            inventory.add(item);
        }
    }

    public void increaseItemQuantity(String itemCode) throws Exception {
        Item item = findItem(itemCode);
        item.setQuantity(item.getQuantity() + 1);
    }
    public void addItem(Item item, String itemCode) throws Exception {
        if(item == null)
        {
            increaseItemQuantity(itemCode);
            return;
        }
        try {
            Item itemInInventory = findItem(itemCode);
            itemInInventory.setQuantity(itemInInventory.getQuantity() + 1);
        } catch (Exception e)
        {
            item.setItemCode(itemCode);
            item.setQuantity(1);
            inventory.add(item);
        }
    }
    public Item findItem(String itemCode) throws Exception {
        return inventory.stream()
                .filter(item -> item.getItemCode().equals(itemCode))
                .findFirst()
                .orElseThrow(() -> new Exception("Item with code: " + itemCode + " not found"));
    }
    public boolean checkItemStock(String itemCode, Integer quantity) throws Exception {
        Item item = findItem(itemCode);
        if(item.getQuantity() >= quantity)
        {
            return true;
        }
        return false;
    }

    public Item getItem(String itemCode) throws Exception {
        Item item = findItem(itemCode);
        return item;
    }

    public void updateItemQuantity(String itemCode, Integer value) throws Exception
    {
        Item item = findItem(itemCode);
        item.setQuantity(value);
    }
}
