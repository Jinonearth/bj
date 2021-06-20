package com.bj.no1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var array = new int[n][n];
        for (int i=0; i<n; i++){
            var row = br.readLine().split(" ");
            for (int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i=0; i<3; i++){
            result[i] = 0;
        }

        validation(array);

        for (int i=0; i<3; i++){
            System.out.println(result[i]);
        }


    }

    public static int[] result = new int[3];

    public static void validation(int[][] arrayPart){
        var l = arrayPart.length;
        boolean success = true;

        for (int i=0; i<l; i++){
            for (int j=0; j<l; j++){
                if(arrayPart[i][j] != arrayPart[0][0]){
                    success = false;
                }
            }
        }

        if (success == false){
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    int[][] arrayNextPart = new int[l/3][l/3];
                    for(int ik=0; ik<l/3; ik++){
                        for(int jk=0; jk<l/3; jk++){
                            arrayNextPart[ik][jk] = arrayPart[i*l/3+ik][j*l/3+jk];
                        }
                    }
                    validation(arrayNextPart);
                }
            }
        } else {
            result[arrayPart[0][0]+1]++;
        }
    }
}
