package com.bj.no1120;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String strIn = sc.nextLine();
        String A = strIn.split(" ")[0];
        String B = strIn.split(" ")[1];

        int lenA = A.length();
        int lenB = B.length();

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i <= lenB - lenA; i++) {
            int localDiff = 0;
            for (int j = 0; j < lenA; j++){
                if (A.substring(j, j+1).equals(B.substring(i+j, i+j+1))) { }
                else {
                    localDiff++;
                }
            }
            diff = Math.min(diff, localDiff);
        }
        System.out.println(diff);
    }
}
