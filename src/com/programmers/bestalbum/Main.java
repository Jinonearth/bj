package com.programmers.bestalbum;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(Arrays.toString(main.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500})));
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<Integer, Integer> playsMap = new HashMap<>();
        ArrayList<String> orderedGenre = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i< genres.length; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            playsMap.put(plays[i], i);
        }
        genreMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> orderedGenre.add(x.getKey()));

        for (var g: orderedGenre){
            ArrayList<Integer> genrePlays = new ArrayList<>();
            for (int j=0; j< genres.length; j++) {
                System.out.println(genres[j]);
                System.out.println(g);
                if (genres[j] == g) {
                    genrePlays.add(plays[j]);
                }
            }

           genrePlays.sort(Comparator.reverseOrder());

           for (var r: genrePlays){
               System.out.println(r);
           }
           System.out.println(genrePlays.size());
               if (genrePlays.size() > 1){
                   result.add(playsMap.get(genrePlays.get(0)));
                   result.add(playsMap.get(genrePlays.get(1)));
               } else {
                   result.add(playsMap.get(genrePlays.get(0)));
               }
        }

        int[] answer = new int[result.size()];
        for (int k=0; k<result.size(); k++){
            answer[k] = result.get(k);
        }
        return answer;
    }
}
