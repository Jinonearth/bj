package com.bj.no1890;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] matrix;
    public static long[][] cache;

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        cache  = new long[n][n];

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cache[i][j] = -99;
            }
        }

        System.out.println(numberOfRouteToDestination(0, 0));
    }

    public static long numberOfRouteToDestination(int i, int j){
        long right = 0;
        long down = 0;
        if(matrix[i][j] == 0 ){
            if (i==n-1 && j==n-1){
                return 1;
            } else return 0;
        }


        if (matrix[i][j] + i < n){
            if (cache[matrix[i][j]+i][j] == -99) {
                right = numberOfRouteToDestination(matrix[i][j] + i, j);
            } else {
                right = cache[matrix[i][j]+i][j];
            }
        }

        if (matrix[i][j] + j < n){
            if (cache[i][matrix[i][j]+j] == -99) {
                down = numberOfRouteToDestination(i, matrix[i][j]+j);
            } else {
                down = cache[i][matrix[i][j]+j];
            }
        }
        cache[i][j] = right+down;
        return right+down;
    }
}
