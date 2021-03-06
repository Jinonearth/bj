package com.bj.no2644;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
        int[] distanceArray = new int[familyNumber+1];

        for (int i=1; i<=familyNumber; i++){
            if (relation[personA][i] == 0) {
                distanceArray[i] = 10000;
            }
            else {
                distanceArray[i] = relation[personA][i];
            }
            distanceArray[personA] = 0;
        }



        for (int i=1; i<=familyNumber; i++){
//            System.out.println("");
            for (int j=1; j<=familyNumber; j++) {
                if (relation[i][j] == 1) {
                    distanceArray[j] = Math.min(distanceArray[j], (distanceArray[i] + relation[i][j]));
                    distanceArray[i] = Math.min(distanceArray[i], (distanceArray[j] + relation[i][j]));
                }
//                System.out.println(distanceArray[j]);
            }
        }

        if (distanceArray[personB] == 10000){
            return -1;
        }
        else {
            return distanceArray[personB];
        }
    }
}
