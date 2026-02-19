package com.lld.designPattern.vendingMachine.vm;

import com.lld.designPattern.vendingMachine.entity.Coin;
import com.lld.designPattern.vendingMachine.entity.Inventory;
import com.lld.designPattern.vendingMachine.entity.ItemShelf;
import com.lld.designPattern.vendingMachine.state.IdleState;
import com.lld.designPattern.vendingMachine.state.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    public Inventory inventory;
    public State currentState;
    List<Coin> coinList;

    public VendingMachine() {
        inventory=new Inventory(10);
        currentState = new IdleState();
        coinList = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
