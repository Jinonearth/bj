package com.bj.no1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws IOException {
        // 0. 읽어들이기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var line = br.readLine().split(" ");
        var n = Integer.parseInt(line[0]);
        var m = Integer.parseInt(line[1]);

        var matrix = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if(i==j){
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 101;
                }
            }
        }

        for (int i=0; i<m; i++){
            line = br.readLine().split(" ");
            var mi = Integer.parseInt(line[0]);
            var mj = Integer.parseInt(line[1]);
            matrix[mi][mj] = 1;
            matrix[mj][mi] = 1;
        }

        for (int k=1; k<=n; k++){
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++){
                    if (matrix[i][j] > matrix[i][k]+matrix[k][j]){
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }

        var min = Integer.MAX_VALUE;
        var who = 0;

        for (int i=1; i<=n; i++) {
            var sum = 0;

            for (int j=1; j<=n; j++){
                sum += matrix[i][j];
                }
            if (min > sum) {
                who = i;
                min = sum;
            }
        }

        System.out.println(who);

    }
}
