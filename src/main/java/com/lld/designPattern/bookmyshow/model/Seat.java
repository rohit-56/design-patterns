package com.lld.designPattern.bookmyshow.model;

public class Seat {

    public int seatId;
    public int row;
    public SeatCategory seatCategory;
    public int price;

    public Seat(int seatId, int row, SeatCategory seatCategory, int price) {
        this.seatId = seatId;
        this.row = row;
        this.seatCategory = seatCategory;
        this.price = price;
    }
}
