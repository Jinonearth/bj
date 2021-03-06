package com.bj.no1920;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> poolPQ = new PriorityQueue<>();
        ArrayDeque<Integer> element = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        var poolNumber = sc.nextInt();
        for (int i=0; i<poolNumber; i++){
            poolPQ.offer(sc.nextInt());
        }

        ArrayList<Integer> poolArr = new ArrayList<>();
        while(!poolPQ.isEmpty()){
            poolArr.add(poolPQ.remove());
        }


        var elementNumber = sc.nextInt();
        for (int j=0; j<elementNumber; j++){
            element.addLast(sc.nextInt());
        }

        Main main = new Main();
        main.check(element, poolArr);
    }


    public void check(ArrayDeque<Integer> search, ArrayList<Integer> target) {
        ArrayList<Integer> result = new ArrayList<>();

        while (!search.isEmpty()) {
            var s = search.remove();
            int low = 0, mid=0, high = target.size()-1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (target.get(mid) < s) {
                    low = mid + 1;
                } else if (target.get(mid) > s) {

                    high = mid - 1;
                } else if (target.get(mid) == s) {
                    result.add(1);
                    break;
                }
            }
            if (target.get(mid) != s){
                result.add(0);
            }

        }
        for (var r : result) {
            System.out.println(r);
        }
    }
}
