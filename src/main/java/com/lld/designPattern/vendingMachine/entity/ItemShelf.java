package com.lld.designPattern.vendingMachine.entity;

public class ItemShelf {

    public int shelfNumber;
    public Item item;
    public boolean isSoldOut;

    public ItemShelf(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
