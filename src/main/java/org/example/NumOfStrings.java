package org.example;

public class NumOfStrings {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String s : patterns) {
            if (word.contains(s)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumOfStrings numOfStrings = new NumOfStrings();
        System.out.println(numOfStrings.numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
    }
}
