package com.bj.no10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        var k = Integer.parseInt(br.readLine());
        Stack<Integer> stackedNumber = new Stack<Integer>();
        for (int i=0;i<k;i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                stackedNumber.pop();
            }
            else{
                stackedNumber.push(n);
            }
        }

        int sum = 0;
        for (int j=0;j<stackedNumber.size();j++) {
            sum += stackedNumber.get(j);
        }
    System.out.println(sum);

    }
}
