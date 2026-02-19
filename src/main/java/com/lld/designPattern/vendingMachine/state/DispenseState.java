package com.lld.designPattern.vendingMachine.state;

import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.entity.Item;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

import java.util.List;

public class DispenseState extends State{

    public DispenseState() {
        System.out.println("Current state is Dispense State");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        System.out.println("Dispense Item "+item.getItemType());
        return item;
    }


    @Override
    public List<Coin> cancelOrderAndReturnFullMoney(VendingMachine vendingMachine) {
        List<Coin> list=vendingMachine.getCoinList();
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
        return list;
    }
}
