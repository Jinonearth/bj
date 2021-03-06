package com.bj.no10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        var cardNumber = Integer.parseInt(br.readLine());
        var cardStatus = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<cardNumber; i++){
            var card = Integer.parseInt(st.nextToken());
            if (cardStatus.containsKey(card)){
                cardStatus.put(card, cardStatus.get(card) + 1);
            } else {
                cardStatus.put(card, 1);
            }
        }

        var cardSetNumber = Integer.parseInt(br.readLine());
        var cardSet = new int[cardSetNumber];
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<cardSetNumber; i++){
            var cardToCheck= Integer.parseInt(st.nextToken());
            if (cardStatus.containsKey(cardToCheck)){
                sb.append(cardStatus.get(cardToCheck));
                sb.append(" ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}
