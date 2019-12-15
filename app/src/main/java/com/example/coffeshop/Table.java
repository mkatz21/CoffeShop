package com.example.coffeshop;

//Table class for future use when we want to have booked tables in appointment slots that can be checked for availability
public class Table {

public Boolean TableOutlet;
public Boolean TableShared;
public Integer TableSeatsNumber;
public String TableSize;

    public Table() {
    }

    public Table(Boolean tableOutlet, Boolean tableShared, Integer tableSeatsNumber, String tableSize) {
        //CoffeShopID = CoffeeShopInfo.key (Need to call the coffeeshopID here)
        TableOutlet = tableOutlet;
        TableShared = tableShared;
        TableSeatsNumber = tableSeatsNumber;
        TableSize = tableSize;
    }
}
