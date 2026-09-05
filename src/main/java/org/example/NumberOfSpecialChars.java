package org.example;

import java.util.Arrays;

public class NumberOfSpecialChars {
//    public int numberOfSpecialChars(String word) {
//        Set<Character> specialChars = new HashSet<>();
//        Map<Character, Integer> lastLowerPos = new HashMap<>();
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (Character.isLowerCase(c)) {
//                if (lastLowerPos.containsKey(Character.toUpperCase(c))) {
//                    lastLowerPos.put(word.charAt(i), -1);
//                    lastLowerPos.put(Character.toUpperCase(c), -1);
//                    specialChars.remove(Character.toUpperCase(c));
//                }else {
//                    lastLowerPos.put(c, i);
//                }
//            } else if (Character.isUpperCase(c)) {
//                char lowerC = Character.toLowerCase(c);
//                if (lastLowerPos.containsKey(lowerC) && lastLowerPos.get(lowerC) != -1 && lastLowerPos.get(lowerC) < i) {
//                    specialChars.add(c);
//                    lastLowerPos.put(Character.toUpperCase(word.charAt(i)), i);
//                }else{
//                    lastLowerPos.put(c, -1);
//                }
//            }
//        }
//
//        return specialChars.size();
//    }

    //    optimal
    public int numberOfSpecialChars(String word) {
        int[] lowerChars = new int[26];
        int[] uppers = new int[26];
        int n = word.length();
        Arrays.fill(lowerChars, -1);
        Arrays.fill(uppers, -1);
        int special = 0;

        for (int i = 0; i < n; i++) {
            char letter = word.charAt(i);
            int ascii = letter;

            if (ascii >= 65 && ascii < 97) {
                if (uppers[letter - 'A'] < 0) {
                    uppers[letter - 'A'] = i;
                }
            } else {
                lowerChars[letter - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowerChars[i] < uppers[i] && uppers[i] >= 0 && lowerChars[i]>=0) special++;
        }

        return special;

    }

    public static void main(String[] args) {
        NumberOfSpecialChars numberOfSpecialChars = new NumberOfSpecialChars();
        System.out.println(numberOfSpecialChars.numberOfSpecialChars("abc"));
    }
}
