package com.lld.designPattern.vendingMachine.state;


import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.entity.Item;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

import java.util.List;

public abstract class State {

    public void clickOnInsertCoinButton(VendingMachine vendingMachine){

    }

    public void clickOnSelectProductButton(VendingMachine vendingMachine){

    }

    public void selectProduct(VendingMachine vendingMachine,int codeNumber){

    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin){

    }

    public Item dispenseProduct(VendingMachine vendingMachine,int codeNumber){

    }

    public int returnChangeCoin(int returnChangeCoin){
        return 0;
    }

    public List<Coin> cancelOrderAndReturnFullMoney(VendingMachine vendingMachine){
     return null;
    }

    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item){

    }
}
