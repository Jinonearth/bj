package com.bj.no2644;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int familyNumber = sc.nextInt();
        int personA = sc.nextInt();
        int personB = sc.nextInt();
        int relationNumber = sc.nextInt();
        int[][] relation = new int[familyNumber+1][familyNumber+1];

        for (int i=0; i<relationNumber; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            relation[parent][child] = 1;
            relation[child][parent] = 1;
        }

        Main main = new Main();
        System.out.println(main.distance(relation, familyNumber, personA, personB));

    }


    public int distance(int[][] relation, int familyNumber, int personA, int personB){
        int[][] distanceArray = new int[familyNumber+1][familyNumber+1];

        for (int i=0; i<=familyNumber; i++){
            for (int j=0; j<=familyNumber; j++)

        }

        for (int i=1; i<=familyNumber; i++){
            if (i==personA){
                distanceArray[personA][i] = 0;
            }
            else{
                if (relation[personA][i] == 1) {
                    distanceArray[personA][i] = 1;
                }
                else{
                    distanceArray[personA][i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=1; i<=familyNumber; i++){
            if (i==personB){
            }
            else{
                for (int j=1; j<=familyNumber; j++)
                if (relation[i][j] == 1) {
//                    distanceArray[i][j] = Math.min(distanceArray[personA][j], distanceArray[i][j]+1 );
                }
                else{
                    distanceArray[personA][i] = Integer.MAX_VALUE;
                }
            }
        }

        int d = Integer.MAX_VALUE;


        return d;
    }

}
