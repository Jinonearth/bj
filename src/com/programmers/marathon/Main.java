package com.programmers.marathon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main (String[] args){
        Main main = new Main();
        System.out.println(main.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> completionMap = new HashMap<>();

        for (var c: completion){
           if (completionMap.containsKey(c)){
               completionMap.put(c, completionMap.get(c)+1);
           } else {
               completionMap.put(c, 1);
           }
        }

        for (var p: participant){
            if (!completionMap.containsKey(p) || completionMap.get(p) == 0){
                answer = p;
                return answer;
            } else {
                completionMap.put(p, completionMap.get(p)-1);
            }
        }
        return answer;
    }
}
