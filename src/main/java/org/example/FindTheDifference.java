package org.example;

import java.util.HashMap;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
       HashMap<Character,Integer> map=new HashMap<>();
       for(char c:s.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
       }
       for(char c:t.toCharArray()){
         if(!map.containsKey(c)){
             return c;
         }
         if(map.containsKey(c)){
             if(map.get(c)==0){
                 return c;
             }
             map.put(c,map.get(c)-1);
         }
       }
       return ' ';
    }

//    public char findTheDifference(String s, String t) { optimal solution
//        char result = 0;
//
//        // XOR all characters in string s
//        for (char c : s.toCharArray()) {
//            result ^= c;
//        }
//
//        // XOR all characters in string t
//        for (char c : t.toCharArray()) {
//            result ^= c;
//        }
//
//        return result;
//
//    }
}
