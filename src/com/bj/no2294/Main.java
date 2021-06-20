package com.bj.no2294;

import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static int[] coin;
    public static int[] coinSum;

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coin = new int[n];
        coinSum = new int[k+1];

        for (int i=0;i<n;i++){
            coin[i] = sc.nextInt();
        }

        for (int i=0; i<k+1; i++){
            coinSum[i] = -99;
        }

        var result = coinNumber(k);
        if (result > 99999){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }

    public static int coinNumber (int sum){

        int min = 100000;
        if (sum < 0){
            return Integer.MAX_VALUE;
        }
        if (sum == 0){
            return 0;
        }


        for (int i=0; i<n; i++){
            if (sum-coin[i] < 0 || coinSum[sum-coin[i]] == -99) {
                min = Math.min(coinNumber(sum-coin[i]), min);
            } else {
                min = Math.min(coinSum[sum-coin[i]], min);
            }
        }
        coinSum[sum] = min + 1;
        return coinSum[sum];
    }

}
