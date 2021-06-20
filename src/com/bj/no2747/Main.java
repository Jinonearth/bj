package com.bj.no2747;

import java.util.Scanner;

public class Main {
    public static int[] cache;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        cache = new int[50];

        for (int i = 1; i < 50; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;

        System.out.println(pibonachi(n));
    }

    public static int pibonachi(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (cache[n] != -1) {
                return cache[n];
            }

            int n_1;
            int n_2;
            n_1 = pibonachi(n - 1);
            n_2 = pibonachi(n - 2);
            cache[n] = n_1 + n_2;
            return cache[n];
        }
    }

}
