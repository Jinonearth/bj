package com.programmers.phonebook;

import java.util.HashMap;

public class Main {
    public static void main (String[] args){

        String[][] st = {{"1", "2"}, {"3", "4"}};
        for (var s: st){
            System.out.println(s[1]);
        }

//        Main main = new Main();
//        System.out.println(main.solution(new String[]{"12","123","1235","567","88"}));
    }

//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//
//
//        for (int i=1; i<=20; i++){
//            HashMap<String, Integer> map = new HashMap<>();
//            for (var n : phone_book){
//                System.out.println(n);
//                if (n.length()<i){
//                    continue;
//                }
//                for (var m: map.entrySet()){
//                    m.get
//                }
//
//                if (n.length() >= i) {
//                    if (map.getOrDefault(n.substring(0, i),0) == i){
//                        answer =false;
//                        break;
//                    }
//                    map.put(n.substring(0, i), n.length());
//                    continue;
//                }
//
//                if (n.length() == i && map.containsKey(n)){
//                    answer = false;
//                    break;
//                }
//
//
//            }
//        }
//        return answer;
//    }
}
