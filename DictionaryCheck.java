package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryCheck {
    private static String text = "aCatsdfgcatcatalogcvbof";

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Should search be case sensitive ? (y/n): ");
        String input = scan.next().toLowerCase();
        if (!input.equals("y") && !input.equals("n")) {
            System.out.println("Please enter valid input");
        }

        // list holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
        bf.close();

        String[] array = listOfStrings.toArray(new String[0]);
        for (String str : array) {
            int result = countMatches(str, text, input);
            System.out.println(str + "  " + result);
        }

    }

    public static int countMatches(String str, String text, String input) {

        if (text.isEmpty() || str.isEmpty()) {
            return 0;
        }
        int index = 0, count = 0;

        while (true) {
            if (input.equals("y")) {
                index = text.indexOf(str, index);
            } else {
                index = text.toLowerCase().indexOf(str.toLowerCase(), index);
            }

            if (index != -1) {
                count++;
                index += str.length();
            } else {
                break;
            }

        }
        return count;
    }
}