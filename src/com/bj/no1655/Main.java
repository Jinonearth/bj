package com.bj.no1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main (String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var rowNumber = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqLower = new PriorityQueue<>((c1, c2) -> c2-c1);
        PriorityQueue<Integer> pqHigher = new PriorityQueue<>((c1, c2) -> c1-c2);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rowNumber; i++){

            var element = Integer.parseInt(br.readLine());;
            pqLower.add (element);

            while (pqLower.size() >= (i+1)/2){
                if (pqLower.size() ==0){
                    break;
                }
                pqHigher.add(pqLower.poll());
            }


            if (pqLower.size() != 0){
                while (pqLower.peek() > pqHigher.peek()){
                    pqLower.add(pqHigher.remove());
                    pqHigher.add(pqLower.remove());
                }
            }

//            System.out.print(pqLower.peek()+  " "+ pqLower.size() + " ");
            sb.append(pqHigher.peek()+"\n");

        }
        System.out.println(sb);
    }
}
