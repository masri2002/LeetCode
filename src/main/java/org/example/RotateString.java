package org.example;

import java.util.ArrayList;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i=0;i<s.length();i++){
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(s.charAt(i));
            if (stringBuilder.toString().equals(goal))return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString string = new RotateString();
        System.out.println(string.rotateString("abcde","abced"));
    }
}
