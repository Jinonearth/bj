package com.bj.no1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var kn = br.readLine().split(" ");
        var k = Integer.parseInt(kn[0]);
        var n = Integer.parseInt(kn[1]);
        var lanCable = new int[k];
        for (int i = 0; i < k; i ++){
            lanCable[i] = Integer.parseInt(br.readLine());
        }
        var count = 0;
        var outMin = ((long) Integer.MAX_VALUE) + 1;
        var inMax = 0L;
        var tryLength = ((long) Integer.MAX_VALUE) + 1;
        while (true){
            //System.out.print(tryLength + " ");
            var exp = 0L;
            for (var l: lanCable){
                exp += l/tryLength;
            }
            if (exp >= n) {
                inMax = tryLength;
            } else if ( exp < n ){
                outMin =  tryLength;
            }
            tryLength = (outMin+inMax)/2;
            if (inMax+1>outMin-1){
                break;
            }
            //System.out.println(inMax + " " + outMin + " " + exp);
        }

        System.out.println(inMax);
    }


}
