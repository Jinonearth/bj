package com.bj.no11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main (String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        var rowNumber = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                var a1 = Math.abs(o1);
                var a2 = Math.abs(o2);
                if (a1 > a2){
                    return 1;
                }
                if (a1 == a2){
                    return o1-o2;
                }
                return -1;
            }
        });
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i=0; i<rowNumber; i++){
            var element = Integer.parseInt(br.readLine());
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
