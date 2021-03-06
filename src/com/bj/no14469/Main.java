package com.bj.no14469;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Cow implements Comparable<Cow>{
        int n;
        int t;
        public Cow (int n, int t) {
            this.n = n;
            this.t = t;
        }
        @Override
        public int compareTo(Cow o) {
            return this.n - o.n;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        var rowNumber = sc.nextInt();
        for (int i=0; i<rowNumber; i++){
            pq.offer(new Cow(sc.nextInt(), sc.nextInt()));
        }

        var elapsedTime = 0;

        while(!pq.isEmpty()){
            var cow = pq.remove();
            var startTime = elapsedTime;
            if (elapsedTime < cow.n){
                startTime = cow.n;
            }
            elapsedTime = startTime + cow.t;
        }
        System.out.println(elapsedTime);
    }
}
