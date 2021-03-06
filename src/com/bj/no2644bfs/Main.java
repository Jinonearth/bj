package com.bj.no2644bfs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int familyNumber = sc.nextInt();
        int personA = sc.nextInt();
        int personB = sc.nextInt();
        int relationNumber = sc.nextInt();
        int[][] relation = new int[familyNumber+1][familyNumber+1];

        for (int i=1; i<=relationNumber; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            relation[parent][child] = 1;
            relation[child][parent] = 1;
        }
        Main main = new Main();
        System.out.println(main.distance(relation, familyNumber, personA, personB));
    }

    public int distance(int[][] relation, int familyNumber, int personA, int personB){
        //bfs
        ArrayDeque<Integer> people = new ArrayDeque<>();
        int[] distance = new int[familyNumber+1];

        for (int i=1; i<=familyNumber; i++){
            distance[i] = -1;
            distance[personA] = 0;
        }
        people.add(personA);

        while(!people.isEmpty()){
            personA = people.removeFirst();

            for (int j=1; j<=familyNumber; j++){
                if (relation[personA][j] == 1 && distance[j] == -1){
                    people.addLast(j);
                    distance[j] = distance[personA] + 1;
                }
            }
        }
        return distance[personB];
    }
}
