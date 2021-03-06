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
            if (this.n > o.n){
                return 1;
            }
            else if (this.n < o.n){
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        var rowNumber = sc.nextInt();
        for (int i=0; i<rowNumber; i++){
            pq.add(new Cow(sc.nextInt(), sc.nextInt()));
        }

        for (var r: pq){
            System.out.println(r.n);
        }

    }
}
