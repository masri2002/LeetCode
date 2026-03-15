package org.example;

import java.util.ArrayList;
import java.util.List;

public class HappyString {
    StringBuilder currentString = new StringBuilder();
    List<String> happyStrings = new ArrayList<>();
    char[] happychars = {'a', 'b', 'c'};
    private int tl;
    private int ti;


    public String getHappyString(int n, int k) {
        tl = n;
        ti = k;
        generateHappyStrings();
        if (k>happyStrings.size()) return "";
        return happyStrings.get(k-1);
    }

    public void generateHappyStrings() {
        if (currentString.length() == tl) {
            happyStrings.add(currentString.toString());
            return;
        }

        if (happyStrings.size() >= ti) {
            return;
        }
        for (char c : happychars) {
            if (currentString.isEmpty() || currentString.charAt(currentString.length() - 1) != c) {
                currentString.append(c);
                generateHappyStrings();
                currentString.deleteCharAt(currentString.length() - 1);
            }
        }
    }
}
