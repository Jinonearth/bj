package com.programmers.truck;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        System.out.println(main.solution(	2, 10, new int[] {7, 4, 5, 6}));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = -1;
            // int weightLimit = weight;

        ArrayDeque<Integer> truckStatus = new ArrayDeque<>();
        truckStatus.addLast(0);

        while(!truckStatus.isEmpty()){
            for (var truck: truck_weights) {
                int weightStatus = 0;
                for (var w:truckStatus) {
                    weightStatus += w ;

                }
                System.out.println("weight: "+weightStatus);

                if (weightStatus <= weight){
                    answer += answer + 1;
                    truckStatus.addLast(truck);
                    truckStatus.removeFirst();

                } else {
                    answer = answer + bridge_length;
                    truckStatus.removeFirst();

                }
                System.out.println(answer);
            }

        }
        return answer;

    }
}
