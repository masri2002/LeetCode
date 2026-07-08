package org.example;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (t.length()!=s.length()) return false;
        int[] frq = new int[26];
        for (char c:s.toCharArray()){
            frq[(c-97)]++;
        }
        for (char c : t.toCharArray()){
            if (frq[c-97]!=0){
                if (frq[c-97]<1){
                    return false;
                }else{
                    frq[c-97]--;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}

