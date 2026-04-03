package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FindEvenNumbers findEvenNumbers = new FindEvenNumbers();
        System.out.println(findEvenNumbers.findEvenNumbers(new int[]{2, 2, 8, 8, 2}));
    }
}