package com.pawan.LLD.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class ArriseAI {

    // Q1 : print even odd problem using 2 threads
    public static final void main(String args[]) throws ExecutionException, InterruptedException {

//        PrintNumber printNumber = new PrintNumber();
//
//        Thread oddThread = new Thread(() -> {
//            printNumber.printNumber(1);
//        }, "odd ");
//
//        Thread evenThread = new Thread(() -> {
//            printNumber.printNumber(0);
//        }, "even");
//
//        oddThread.start();
//        evenThread.start();

        // Q2 add 1-100 using parallel parallel processing
        new ParallelBatchSum().parallelBatchSum();
    }
}

class PrintNumber {

    private int limit = 200;
    private AtomicInteger ai = new AtomicInteger(1);

    public synchronized void printNumber(int reminder) {

        while(ai.get() <= limit) {
            while(ai.get()%2 != reminder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if(ai.get() <= limit) {
                System.out.println("Thread " + Thread.currentThread().getName() + " : " + ai.get());
                ai.set(ai.get() + 1);
                notify();
            }
        }
    }

    // Q3 : linkedHashmap internal implementation :
}

class ParallelBatchSum {
    // Q2 add 1-100 using parallel parallel processing

    public void parallelBatchSum() throws ExecutionException, InterruptedException {
        int start = 1, end = 100;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for(int i = start; i<=end; i+=10) {
            int s = i;
            int e = Math.min(i + 9, end);
            CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> sum(s, e), executor);
            futures.add(c);
        }
        CompletableFuture[] arr = futures.toArray(new CompletableFuture[0]);
        CompletableFuture.allOf(arr).join();


        int sum = 0;
        for(CompletableFuture<Integer> c : futures) {
            sum += c.get();
        }

        executor.shutdown();

        System.out.println("Total sum : " + sum);
    }

    public int sum(int l, int h) {
        int sum = 0;
        for(int i=l; i<=h; i++) {
            sum+=i;
        }
        return sum;
    }
}
