package com.lld.designPattern.vendingMachine;

import com.lld.designPattern.vendingMachine.entity.*;
import com.lld.designPattern.vendingMachine.state.State;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

public class VendingMachineDemoTest {

    public VendingMachineDemoTest() {

        VendingMachine vendingMachine = new VendingMachine();

        //Fill up inventory
        initializeInventory(vendingMachine);

        //Display Inventory
        displayInventory(vendingMachine);

        State currentState = vendingMachine.getCurrentState();

        currentState.clickOnInsertCoinButton(vendingMachine);

        currentState=vendingMachine.getCurrentState();
        currentState.insertCoin(vendingMachine, Coin.TEN_RUPEE_COIN);
        currentState.insertCoin(vendingMachine, Coin.TEN_RUPEE_COIN);
        currentState.insertCoin(vendingMachine, Coin.TEN_RUPEE_COIN);
        currentState.insertCoin(vendingMachine, Coin.FIVE_RUPEE_COIN);

        currentState.clickOnSelectProductButton(vendingMachine);

        currentState=vendingMachine.getCurrentState();

        currentState.selectProduct(vendingMachine,104);


        displayInventory(vendingMachine);


        //Now Vending machine again in idle state
        //Now buy water

        currentState=vendingMachine.getCurrentState();

        currentState.clickOnInsertCoinButton(vendingMachine);
        currentState=vendingMachine.getCurrentState();

        currentState.insertCoin(vendingMachine, Coin.TEN_RUPEE_COIN);

        currentState.clickOnSelectProductButton(vendingMachine);

        currentState=vendingMachine.getCurrentState();

        currentState.selectProduct(vendingMachine,108);

        displayInventory(vendingMachine);


    }

    public void initializeInventory(VendingMachine vendingMachine) {
        ItemShelf[] shelves = vendingMachine.getInventory().inventory;
        for(int i=0;i<shelves.length;i++) {
           if(i>=0 && i<=2){
               shelves[i].setItem(new Item(ItemType.COKE,20));
               shelves[i].setSoldOut(false);
           }
           else if(i>=3 && i<=5){
               shelves[i].setItem(new Item(ItemType.PEPSI,15));
               shelves[i].setSoldOut(false);
           }
           else if(i>=6 && i<=7){
               shelves[i].setItem(new Item(ItemType.WATER,10));
               shelves[i].setSoldOut(false);
           }
           else{
               shelves[i].setItem(new Item(ItemType.JUICE,30));
               shelves[i].setSoldOut(false);
           }
        }
    }

    public void displayInventory(VendingMachine vendingMachine) {
        System.out.println("---------------------------------------------------------");
         for (int i=0;i<10;i++){
             ItemShelf shelf =  vendingMachine.getInventory().inventory[i];
             if(shelf.isSoldOut()==false) {
                 Item item = shelf.getItem();
                 System.out.println("Item in Shelf " + shelf.getShelfNumber() + " :" + item.getItemType() + " has price :" + item.getPrice());
             }
         }
    }
}
