package com.bj.no11652;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var tc = Integer.parseInt(br.readLine());
        TreeMap<Long, Integer> tm = new TreeMap<>();
        for (int i = 0; i < tc; i++){
            var id = Long.parseLong(br.readLine());
            tm.put(id, tm.getOrDefault(id, 0)+1);
        }

        var max = 0;
        var maxKey = 0L;
        for (var t: tm.entrySet()){
            if (max < t.getValue()){
                max = t.getValue();
                maxKey = t.getKey();
            }

        }
        System.out.println(maxKey);
    }
}
