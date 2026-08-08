package org.example;

import java.util.ArrayList;

public class MinStack {

    private ArrayList<Integer> stack;
    private ArrayList<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.getLast()) {
            minStack.add(val);
        }
    }

    public void pop() {
        if (stack.getLast().equals(minStack.getLast())) {
            minStack.removeLast();
        }

        stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
