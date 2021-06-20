package com.bj.no15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int[] visited;
    public static void main (String[] args) throws IOException {

        // 0. 읽어들이기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var k = Integer.parseInt(br.readLine());
        var adjlist = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=k+1; i++){
            adjlist.add(i, new ArrayList<Integer>());
        }

        for (int i=0; i<k-1; i++){
            var line = br.readLine().split(" ");
            adjlist.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            adjlist.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }


        // 1. 트리를 구성
        // 2. 모든 노드리프에서 root까지의 노드 수 구하기
        visited = new int[k+1];
        visited[1] = 1;
        dfs(1, 0, adjlist);

        // 3. 홀수면 승리 / 짝수면 패배
        if (depthSum % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static int depthSum = 0;


    public static void dfs(int index, int depth, ArrayList<ArrayList<Integer>> adjlist){
        var leaf = 1;
        for (var i: adjlist.get(index)){
            if (visited[i] == 1){
                continue;
            } else {
                visited[i] = 1;
                leaf = 0;
                dfs(i, depth+1, adjlist);
            }
        }
        if (leaf == 1){
            depthSum += depth;
        }
    }


}
