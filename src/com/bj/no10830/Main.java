package com.bj.no10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var ab = br.readLine().split(" ");
        var a = Integer.parseInt(ab[0]);
        var b = Long.parseLong(ab[1]);
        var matrix = new int[a][a];
        var basematrix = new int[a][a];
        for (int i=0; i<a; i++){
            var row = br.readLine().split(" ");
            for (int j=0; j<a; j++){
                matrix[i][j] = Integer.parseInt(row[j]);
                if (i==j){
                    basematrix[i][j] = 1;
                }
            }
        }




        var binaryB = toBinary(b);

        var tempmatrixTimes = matrix;
        var result = basematrix;
        for (int i=0;i<40;i++){
            if (binaryB[i] == 1){
                result = matrixTimes(result, tempmatrixTimes);
            }
            tempmatrixTimes = matrixTimes(tempmatrixTimes, tempmatrixTimes);
        }


//        int[][] temp = matrix;
//        for (int i=1; i<b; i++){
//            temp = matrixTimes(temp, matrix);
//        }

        for (int i=0; i<a; i++) {
            for (int j=0; j<a; j++) {
                System.out.print(result[i][j]%1000+" ");
            }
            System.out.println("");
        }
    }



    public static int[] toBinary(long decimal){
        int binary[] = new int[40];
        int index = 0;
        while(decimal > 0) {
            if (decimal % 2 == 1){
                binary[index] = 1;
            }
            index++;
            decimal = decimal / 2;
        }
        return binary;
    }

    public static int[][] matrixTimes (int[][] matrix, int[][] matrix2){
        int l = matrix.length;
        int[][] matrixTime = new int[l][l];
        for (int i=0; i<l; i++){
            for (int j=0; j<l; j++){
                int sum = 0;
                for (int k=0; k<l; k++){
                    sum += matrix[i][k]*matrix2[k][j];
                }
                matrixTime[i][j] = sum%1000;
            }
        }
        return matrixTime;
    }
}
