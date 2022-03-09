package com.homework.store;

public class Main {
    public static void main(String[] args) {
        ReadCsv read = new ReadCsv("buyers.csv");
        Seller seller = new Seller("admin","admin");
        seller.writeBuyers(read.readCsv());
    }
}
