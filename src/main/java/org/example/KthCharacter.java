package org.example;

import java.util.ArrayList;
import java.util.List;

public class KthCharacter {
    public char kthCharacter(int k) {
        List<Integer> characterValues = new ArrayList<>();
        characterValues.add(0);
        while (characterValues.size() < k) {
            int currentSize = characterValues.size();
            for (int i = 0; i < currentSize; i++) {
                int shiftedValue = (characterValues.get(i) + 1) % 26;
                characterValues.add(shiftedValue);
            }
        }

        return (char) ('a' + (characterValues.get(k - 1)));
    }

//    public char kthCharacter(int k) { optimal solution
//        char[] charArray = new char[k];
//        charArray[0]='a';
//        int count=0, len, i=1,j;
//
//        while(i<k){
//            len = 1 << count++;
//            for(j=0; j<len; i++, j++){
//                if(i==k){
//                    return charArray[k-1];
//                }
//                charArray[i] = (char) (charArray[j]+1);
//            }
//        }
//
//        return charArray[k-1];
//    }
}
