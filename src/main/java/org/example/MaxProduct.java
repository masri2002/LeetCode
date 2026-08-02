package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProduct {
    public int maxProduct(int n) {
        if (n < 10) {
            return n * n;
        }
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        if (list.size() >= 2) {
            return list.get(list.size() - 2) * list.get(list.size() - 1);
        }
        return list.get(0) * list.get(0);
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(22));
    }
}
