package com.lld.designPattern.vendingMachine.state;

import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.entity.Item;
import com.lld.designPattern.vendingMachine.vm.VendingMachine;

import java.util.List;

public class DispenseState extends State{

    public DispenseState(VendingMachine vendingMachine,int codeNumber) {
        System.out.println("Current state is Dispense State");
        dispenseProduct(vendingMachine,codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        System.out.println("Dispense Item "+item.getItemType());
        vendingMachine.getInventory().updateItemSoldOut(codeNumber,true);
        vendingMachine.getInventory().setItem(codeNumber,null);
        return item;
    }


    @Override
    public List<Coin> cancelOrderAndReturnFullMoney(VendingMachine vendingMachine) {
        List<Coin> list=vendingMachine.getCoinList();
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
        return list;
    }
}
