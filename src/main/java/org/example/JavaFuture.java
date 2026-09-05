package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class JavaFuture {

    public static class SquareCalculator {

        private final ExecutorService executor
                = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        public Future<Integer> calculate(Integer input) {
            return executor.submit(() -> {
                Thread.sleep(1000);
                return input * input;
            });
        }

        public void shutdown() {
            executor.shutdown();
        }
    }

    public static class FactorialSquareCalculator extends RecursiveTask<Integer> {

        private Integer n;

        public FactorialSquareCalculator(Integer n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }

            FactorialSquareCalculator calculator
                    = new FactorialSquareCalculator(n - 1);

            calculator.fork();

            return n * calculator.join();
        }
    }

    public List<Future<List<ValidationResult>>> checkAccounts(
            List<String> accounts) {

        int numOfThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService executor =
                Executors.newFixedThreadPool(numOfThreads);

        List<Future<List<ValidationResult>>> futures = new ArrayList<>();

        int chunkSize =
                (int) Math.ceil((double) accounts.size() / numOfThreads);

        for (int i = 0; i < accounts.size(); i += chunkSize) {

            int fromIndex = i;
            int toIndex = Math.min(i + chunkSize, accounts.size());

            futures.add(executor.submit(() -> {
       Thread.sleep(1000);
                List<ValidationResult> results = new ArrayList<>();

                for (int index = fromIndex; index < toIndex; index++) {

                    String account = accounts.get(index);

                    try {
                        validateAccount(account);

                        results.add(
                                new ValidationResult(index, account, "Valid")
                        );

                    } catch (IllegalArgumentException e) {

                        results.add(
                                new ValidationResult(
                                        index,
                                        account,
                                        "Invalid: " + e.getMessage()
                                )
                        );

                        // continue with next account
                    }
                }
                return results;
            }));
        }

        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHhh");
        executor.shutdown();

        return futures;
    }

    public void validateAccount(String account) throws IllegalArgumentException {
        if (account.equals("K")) {
            throw new IllegalArgumentException();
        }
    }

    class ValidationResult {

        private final int index;
        private final String account;
        private final String result;

        public ValidationResult(int index, String account, String result) {
            this.index = index;
            this.account = account;
            this.result = result;
        }

        @Override
        public String toString() {
            return "ValidationResult{" +
                    "index=" + index +
                    ", account='" + account + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) throws Exception {
        List<String> accounts = new ArrayList<>();
        accounts.add("A");
        accounts.add("B");
        accounts.add("C");
        accounts.add("D");
        accounts.add("E");
        accounts.add("F");
        accounts.add("G");
        accounts.add("H");
        accounts.add("I");
        accounts.add("J");
        accounts.add("K");
        accounts.add("L");
        accounts.add("M");
        accounts.add("N");
        accounts.add("O");
        accounts.add("P");

        JavaFuture javaFuture = new JavaFuture();
        List<Future<List<ValidationResult>>> futures = javaFuture.checkAccounts(accounts);
        for (Future<List<ValidationResult>> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | IllegalArgumentException | ExecutionException e) {

            }
        }

    }
}
