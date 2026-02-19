package com.lld.designPattern.vendingMachine.state;

import com.lld.designPattern.vendingMachine.entity.Item;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

import java.util.ArrayList;

public class IdleState extends State{

    public IdleState() {
        System.out.println("Current state is Idle State");
    }

    public IdleState(VendingMachine vm) {
        System.out.println("Current state is Idle State");
        vm.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setCurrentState(new InsertMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
