package com.lld.designPattern.vendingMachine.state;


import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.entity.Item;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

import java.util.List;

public class SelectProductState extends State{

    public SelectProductState() {
        System.out.println("Current State is Select Product State");

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) {
        //select Item
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        //Calculate total amount from insert coin
        int amount=0;
        List<Coin> list=vendingMachine.getCoinList();
        for(Coin coin:list){
            amount+=coin.value;
        }

        //check price paid >= price of item selected
        if(amount>=item.getPrice()){
            returnChangeCoin(amount-item.getPrice());
            vendingMachine.setCurrentState(new DispenseState());
        }
        else{
            returnChangeCoin(amount);
            vendingMachine.setCurrentState(new IdleState(vendingMachine));
        }
    }

    @Override
    public int returnChangeCoin(int returnChangeCoin) {
        System.out.println("Change Coin Return "+returnChangeCoin);
        return returnChangeCoin;
    }

    @Override
    public List<Coin> cancelOrderAndReturnFullMoney(VendingMachine vendingMachine) {
        List<Coin> list=vendingMachine.getCoinList();
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
        return list;
    }
}
