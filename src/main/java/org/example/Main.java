package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       LongestSubarray subarray=new LongestSubarray();
        System.out.println( subarray.longestSubarray(new int [] {1,5,6,7,8,10,6,5,6},4));
    }
}