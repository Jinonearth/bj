package com.programmers.printer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
            int answer = 0;
            ArrayList<Integer> result = new ArrayList<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i=0; i< priorities.length; i++){
                    q.addLast(i);
                }

            for (int j=10; j>0; j--){
                var count = 0;
                var localCount = 0;
                for (var p: priorities){
                    if (p == j) {
                        count++;
                    }
                }
                while(localCount != count){
                    var element = q.removeFirst();
                    System.out.println("max: " + j + " " + element + " "+ priorities[element]);
                    if (priorities[element] == j){
                        result.add(element);
                        localCount++;
                    } else {
                        q.addLast(element);
                    }
                }
            }

            for (int n=0; n<result.size(); n++){
                if (result.get(n) == location) {
                    answer = n+1;
                }
            }
            return answer;
    }
}
