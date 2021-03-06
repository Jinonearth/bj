package com.bj.no1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );


        ArrayList<Integer> result = new ArrayList<>();
        var poolNumber = Integer.parseInt(br.readLine());
        int[] pool = new int[poolNumber];
        var st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<poolNumber; i++){
            pool[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pool);

        var elementNumber = Integer.parseInt(br.readLine());
        var element = new int[elementNumber];
        st = new StringTokenizer(br.readLine(), " ");

        for (int j=0; j<elementNumber; j++){
            element[j] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        main.check(element, pool);
    }


    public void check(int[] search, int[] target) {
        ArrayList<Integer> result = new ArrayList<>();

        for (var s: search) {
            if (Arrays.binarySearch(target, s) >= 0 ) {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        var sb = new StringBuilder();

        for (var r : result) {
            sb.append(r);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
