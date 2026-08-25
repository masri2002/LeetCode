package org.example;

public class CheckDivisibility {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int digit = n;
        while (digit > 0) {
            int i = digit % 10;
            sum += i;
            product *= i;
            digit = digit / 10;
        }
        return n % (sum + product) == 0;
    }

    public static void main(String[] args) {
        CheckDivisibility checkDivisibility = new CheckDivisibility();
        System.out.println(checkDivisibility.checkDivisibility(99));
    }
}
