package com.bj.no11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visit = new int[n+1];
        ArrayList<Integer>[] matrix = new ArrayList[n+1];
        for (int i=0; i<=n; i++){
            matrix[i] = new ArrayList<>();
        }

        for (int i=1; i<n; i++){
            var node = br.readLine().split(" ");
            var n1 = Integer.parseInt(node[0]);
            var n2 = Integer.parseInt(node[1]);
            matrix[n1].add(n2);
            matrix[n2].add(n1);
        }

        Main main = new Main();
        main.dfs(1, matrix);

        StringBuilder sb = new StringBuilder();

        for (int i=2; i<=n; i++){
            sb.append(parent[i]);
            sb.append("\n");

        }

        System.out.println(sb.toString());

    }
    public static int n;
    public static int[] parent;
    public static int[] visit;

    public void dfs(int visitNode, ArrayList<Integer>[] matrix) {

        for (int n : matrix[visitNode]){
            if (visit[n] != 0) {
                continue;
            }
            visit[visitNode] = 1;
            parent[n] = visitNode;
//            System.out.println(parent[n] + " " + n);
            dfs(n, matrix);
        }

    }
}
