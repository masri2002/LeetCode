package org.example;

import java.util.ArrayList;

public class reverseVowels {
    public String reverseVowels(String s) {

        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char [] c = s.toCharArray();
        int l=0;
        int r=c.length-1;
        while(l<r){
            if(!vowels.contains(c[l])){
                l++;
            }else if(!vowels.contains(c[r])){
                r--;
            }else{
                char temp = c[l]; //hollo
                c[l] = c[r];
                c[r] = temp;
                l++;
                r--;
            }
        }
        String s1=new String(c);
    return s1;
    }
}
