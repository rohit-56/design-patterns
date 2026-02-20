package com.lld.designPattern.vendingMachine.entity;

public class Inventory {

    public ItemShelf inventory[];

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeInventory();
    }

    private void initializeInventory() {
        int start=101;
        for(int i=0;i<inventory.length;i++) {
            inventory[i]=new ItemShelf(start);
            inventory[i].setSoldOut(true);
            start++;
        }

    }

    public void setItem(int codeNumber, Item item) {
        for(int i=0;i<inventory.length;i++) {
            if(inventory[i].getShelfNumber()==codeNumber) {
                inventory[i].setItem(item);
                return;
            }
        }
    }

    public void addItem(Item item,int codeNumber) {
        for(int i=0;i<inventory.length;i++) {
            if(inventory[i].getShelfNumber()==codeNumber && inventory[i].isSoldOut()==false){
                throw new RuntimeException("Item is already present");
            }
            else if(inventory[i].getShelfNumber()==codeNumber){
                inventory[i].setItem(item);
                return;
            }

        }
    }
    public Item getItem(int codeNumber) {
       for (int i=0;i<inventory.length;i++) {
           if(inventory[i].getShelfNumber()==codeNumber){
               return inventory[i].getItem();
           }
       }
       return null;
    }

    public void updateItemSoldOut(int codeNumber,boolean status) {
        for(int i=0;i<inventory.length;i++) {
            if(inventory[i].getShelfNumber()==codeNumber){
                inventory[i].setSoldOut(status);
            }
        }
    }
}
