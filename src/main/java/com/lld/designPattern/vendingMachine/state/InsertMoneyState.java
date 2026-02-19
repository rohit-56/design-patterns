package com.lld.designPattern.vendingMachine.state;

import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

public class InsertMoneyState extends State{

    public InsertMoneyState() {
        System.out.println("Current state is Insert Money State");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Accepting the Coin " +coin.value);
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new SelectProductState());
    }
}
