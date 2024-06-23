package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class StringCompression {
    public int compress(char[] chars) {
        HashMap<Character,Integer> map=new HashMap();
        for(char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        String comp="";
        for(char c : map.keySet()){
            if(map.get(c)==1){
                comp+=c+"";
            }else {
                comp +=c + "" + (map.get(c));
            }
            }
        System.out.println(comp);
        for (int i=0;i<comp.length();i++){
            chars[i]=comp.charAt(i);
        }
        System.out.println(map.toString());
        for(char x : chars){
            System.out.print(x + " ");
        }
        return comp.length();
    }

}
