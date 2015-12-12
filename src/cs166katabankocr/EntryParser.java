/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs166katabankocr;

import java.util.ArrayList;

/**
 *
 * @author Justine Francis
 */
public class EntryParser {

    String line1, line2, line3;

    String topChars, midChars, botChars;

    public void getLines(ArrayList<String> input) {
        line1 = input.get(0);
        line2 = input.get(1);
        line3 = input.get(2);
    }

    public String generateNumber(String top, String mid, String bot) {
        if (top.equals("   ")
                && mid.equals("  |")
                && bot.equals("  |")) {
            return "1";
        } else if (top.equals(" _ ")
                && mid.equals(" _|")
                && bot.equals("|_ ")) {
            return "2";
        } else if (top.equals(" _ ")
                && mid.equals(" _|")
                && bot.equals(" _|")) {
            return "3";
        } else if (top.equals("   ")
                && mid.equals("|_|")
                && bot.equals("  |")) {
            return "4";
        } else if (top.equals(" _ ")
                && mid.equals("|_ ")
                && bot.equals(" _|")) {
            return "5";
        } else if (top.equals(" _ ")
                && mid.equals("|_ ")
                && bot.equals("|_|")) {
            return "6";
        } else if (top.equals(" _ ")
                && mid.equals("  |")
                && bot.equals("  |")) {
            return "7";
        } else if (top.equals(" _ ")
                && mid.equals("|_|")
                && bot.equals("|_|")) {
            return "8";
        } else if (top.equals(" _ ")
                && mid.equals("|_|")
                && bot.equals(" _|")) {
            return "9";
        } else if (top.equals(" _ ")
                && mid.equals("| |")
                && bot.equals("|_|")) {
            return "0";
        } 
        
        return "?";

    }

    public String parseDigits(String top, String mid, String bot) {
        String output = "";
        if (top.length() < mid.length()) {
            top = top + " ";
        }
        for (int i = 0; i < top.length(); i += 3) {
            topChars = top.substring(i, i + 3);
            midChars = mid.substring(i, i + 3);
            botChars = bot.substring(i, i + 3);

            output += generateNumber(topChars, midChars, botChars);
        }

        return output;
    }

    public ArrayList<String> parseEntries(ArrayList<String> entries) {

        ArrayList<String> outputs = new ArrayList();
        for (int i = 0; i < entries.size(); i += 4) {
            String top = entries.get(i);
            String mid = entries.get(i + 1);
            String bot = entries.get(i + 2);

            if (validAccountNumber(parseDigits(top, mid, bot))) {
                outputs.add(parseDigits(top, mid, bot));
            } else if (parseDigits(top, mid, bot).contains("?")) {
                outputs.add(parseDigits(top, mid, bot) + " ILL");
            }else
            outputs.add(parseDigits(top, mid, bot) + " ERR");
        }

        return outputs;
    }

    public boolean validAccountNumber(String input) {
        int sum = 0;
        for (int i = input.length() - 1, multiplier = 1; i >= 0; i--, multiplier++) {
            int x = (int) (input.charAt(i) - 48) * multiplier;
            sum = sum + x;
        }

        return sum % 11 == 0;

    }

}
