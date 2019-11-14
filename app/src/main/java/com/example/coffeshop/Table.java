package com.example.coffeshop;

public class Table {

public Boolean TableOutlet;
public Boolean TableShared;
public Integer TableSeatsNumber;
public String TableSize;

    public Table() {
    }

    public Table(Boolean tableOutlet, Boolean tableShared, Integer tableSeatsNumber, String tableSize) {
        TableOutlet = tableOutlet;
        TableShared = tableShared;
        TableSeatsNumber = tableSeatsNumber;
        TableSize = tableSize;
    }
}
