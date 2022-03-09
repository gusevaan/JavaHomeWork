package com.homework.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Seller extends UserAbstract
{
    String CSV_SEPARATOR = ",";
    public Seller(String login, String password) {
        super(login, password);
    }
    public void writeBuyers(List<Buyer> buyersList)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("activeBuyers.csv"))) {
            buyersList.forEach(buyer -> {
                try {
                    writer.append(buyer.getUUID()).append(CSV_SEPARATOR)
                            .append(String.valueOf(buyer.getId())).append(CSV_SEPARATOR)
                            .append(buyer.getFio()).append(CSV_SEPARATOR)
                            .append(buyer.getFio()).append(CSV_SEPARATOR)
                            .append(buyer.getLogin()).append(CSV_SEPARATOR)
                            .append(buyer.getPhone()).append(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
