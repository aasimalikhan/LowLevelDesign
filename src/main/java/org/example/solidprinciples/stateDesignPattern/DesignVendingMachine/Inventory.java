package org.example.solidprinciples.stateDesignPattern.DesignVendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;
    public Inventory(int itemCount)
    {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }
    public void initialEmptyInventory()
    {
        int startCode = 101;
        for(int i = 0; i < inventory.length; i++)
        {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }
    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                if(itemShelf.isSoldOut())
                {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                }
                else {
                    throw new Exception("item is already present, you cannot add item here");
                }
            }
        }
    }
    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                if(itemShelf.isSoldOut())
                {
                    throw new Exception("item sold out");
                }
                else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid code");
    }

    public void updateSoldOutItem(int codeNumber)
    {
        for(ItemShelf itemShelf : inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
