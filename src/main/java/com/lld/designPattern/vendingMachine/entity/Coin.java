package com.lld.designPattern.vendingMachine.entity;

public enum Coin {
    FIVE_RUPEE_COIN(5),
    TEN_RUPEE_COIN(10);


    public int value;

    Coin(int value) {
        this.value = value;
    }
}
