package org.example;

public class reverseWords {
    public String reverseWords(String s) {
     String[] words = s.split("//s+");
     String reversed = "";
     for (int i = words.length - 1; i >= 0; i--) {
          if (words[i].length() > 0) {
              reversed += words[i] + " ";
          }else if(words[i].length() == 0){
              reversed += words[i];
          }


     }
     return reversed;
    }
}
