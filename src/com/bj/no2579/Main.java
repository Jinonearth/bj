package com.bj.no2579;

import java.util.Scanner;

public class Main {

    public static int lastStairNumber;
    public static int[] stairs;
    public static int[][] maxScores;

    public static void main (String[] args){
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        lastStairNumber = n;
        stairs = new int[n+1];
        maxScores = new int[n+1][2];
        for (int i=1;i<=n;i++){
            stairs[i] = sc.nextInt();
            maxScores[i][0] = -1;
            maxScores[i][1] = -1;
        }

        if (n == 1){
            System.out.println(stairs[1]);
        } else if (n == 2){
            System.out.println(stairs[1] + stairs[2]);
        } else {
                System.out.println(Math.max(maxScore(1, 0), maxScore(2, 0)));
        }


    }

    public static int maxScore(int n, int before){

        if (n == lastStairNumber-2){
            return stairs[n] + stairs[n+2];
        } else if (n == lastStairNumber-1){
            if (before == 1){
                return Integer.MIN_VALUE;
            } else if (before ==0){
                return stairs[n] + stairs[n+1];
            }
        }

        if (maxScores[n][before] != -1){
            return maxScores[n][before];
        }

        if (before == 0){
            maxScores[n][before] = Math.max(stairs[n] + maxScore(n+1, 1),
                                            stairs[n] + maxScore(n+2, 0));
            return Math.max(stairs[n] + maxScore(n+1, 1),
                            stairs[n] + maxScore(n+2, 0));

        } else if (before == 1){
            maxScores[n][before] = stairs[n] + maxScore(n+2, 0);
            return stairs[n] + maxScore(n+2, 0);
        }
            return 0;
    }
}
