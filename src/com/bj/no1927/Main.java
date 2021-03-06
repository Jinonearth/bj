package com.bj.no1927;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        var rowNumber = sc.nextInt();
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i=0; i<rowNumber; i++){
            var element = sc.nextInt();
            if (element==0) {
                if (arr.isEmpty()) {
                    result.addLast(0);
                    continue;
                }
                result.addLast((arr.remove()));
                continue;
            }
            arr.add(element);
            continue;
            }

        for (var r: result){
            System.out.println(r);
        }
    }
}

