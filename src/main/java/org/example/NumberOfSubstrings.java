package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
     int res =0;
        Map<Character,Integer> lastIdx= new HashMap<>();
        lastIdx.put('a',-1);
        lastIdx.put('b',-1);
        lastIdx.put('c',-1);
      for (int i =0;i<s.length();i++){
         lastIdx.put(s.charAt(i),i);
         res+=Math.min(lastIdx.get('c'),Math.min(lastIdx.get('a'),lastIdx.get('b')))+1;
      }
      return res;
    }

    public static void main(String[] args) {
        NumberOfSubstrings number = new NumberOfSubstrings();
        System.out.println(number.numberOfSubstrings("abcabc"));
    }
}
