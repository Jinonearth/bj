package com.bj.no9012;

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


        Main main = new Main();
        for (int i=0;i<k;i++) {
            String row = br.readLine();
            System.out.println(main.pass(row));
            }
    }
    public String pass(String row){

        Stack<Integer> stackRow = new Stack<Integer>();
        for (int j=0;j<row.length();j++){
            if (row.substring(j,j+1).equals("(")) {
                stackRow.push(1);
            }
            else {
                if (stackRow.isEmpty()) {
                    return "NO";
                }
                stackRow.pop();
            }
        }

        if (stackRow.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

