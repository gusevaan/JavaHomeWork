package com.homework.store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class ReadCsv
{
    static String COMMA_DELIMITER = ",";
    private List<Buyer> userList = new ArrayList<>();
    private String regex = "\\d{0,10},[А-я ё]+,[A-z]+,\\S+,((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private String fileName;

    public ReadCsv(String fileName)
    {
        this.fileName = fileName;
    }

    private static boolean isMatches(String regex, String line)
    {
        return Pattern.matches(regex,line);
    }

    public List<Buyer> readCsv()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); //skip header
            int currentLine = 2;
            String line;
            while ((line = br.readLine()) != null) {
                if(isMatches(regex, line))
                {
                    String[] values = line.split(COMMA_DELIMITER);
                    userList.add(new Buyer(
                            UUID.randomUUID().toString(),
                            Integer.parseInt(values[0]),
                            values[1],
                            values[2],
                            values[3],
                            values[4])
                    );
                    currentLine++;
                }else {
                    System.out.println("Не удалось обработать строку № "+ currentLine + ": " + line);
                    currentLine++;
                }
                Collections.sort(userList, Comparator.comparing(Buyer::getFio));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
