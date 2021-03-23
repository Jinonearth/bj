package com.bj.no1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var cityNumber = Integer.parseInt(br.readLine());
        var busNumber = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Bus>> busList = new ArrayList<>();
        for (int i=0; i<=cityNumber; i++){
            busList.add(new ArrayList<Bus>());
        }

        var distance = new int[cityNumber+1];
        var visited = new int[cityNumber+1];
        var dij = new PriorityQueue<MinDistance>(new Comparator<MinDistance>() {
            @Override
            public int compare(MinDistance o1, MinDistance o2) {
                return o1.minDistance - o2.minDistance;
            }
        });

        for (int i = 0; i <= cityNumber; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= busNumber; i++){
            var row = br.readLine().split(" ");
            busList.get(Integer.parseInt(row[0]))
                    .add(new Bus(Integer.parseInt(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2])));
        }

        var destination = br.readLine().split(" ");

        dij.add(new MinDistance(Integer.parseInt(destination[0]), 0));



        while (!dij.isEmpty()){
            var polled = dij.poll();
            for (var b : busList.get(polled.city)){
                if (visited[polled.city] != 1) {
                    if (polled.minDistance + b.time < distance[b.arrive]){
                        distance[b.arrive] = polled.minDistance + b.time;
                        dij.add(new MinDistance(b.arrive, distance[b.arrive]));

                    }
                }
            }
            visited[polled.city] = 1;
        };

        System.out.print(distance[Integer.parseInt(destination[1])]);
    }

    public static class MinDistance{
        int city;
        int minDistance;
        public MinDistance (int city, int minDistance) {
            this.city = city;
            this.minDistance   = minDistance;
        }
    }


    public static class Bus{
        int depart;
        int arrive;
        int time;
        public Bus (int depart, int arrive, int time) {
            this.depart = depart;
            this.arrive = arrive;
            this.time   = time;
        }
    }

}
