package com.bj.no2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        var condition = br.readLine().split(" ");
        var m = Integer.parseInt(condition[0]);
        var n = Integer.parseInt(condition[1]);
        int [][] arr = new int[n][m];
        for (int y=0; y<n; y++){
            var row = br.readLine().split("");
            for (int x=0; x<n; x++){
                arr[y][x] = Integer.parseInt(row[x]);
            }
        }

        Main main = new Main();
        System.out.println(main.result(arr, m, n));
    }

    public int[][] cost;
    public boolean[][] visited;

    public int result(int[][] arr, int m, int n){
        cost = new int[n][m];
        visited = new boolean[n][m];
        for (int x=0; x<m; x++){
            for (int y=0; y<n; y++){
                if (dfs(arr, x, y, m, n)){
                    visited[y][x] = true;
                };
            }
        }
        return cost[n][m];
    }

    public boolean dfs(int[][] arr, int x, int y, int m, int n){
        if (x<0 || y<0 || x>m || y>n || arr[y][x] == 0 || visited[y][x] == true){
            return false;
        }
        else {
            dfs(arr, x-1, y, m, n);
            dfs(arr, x+1, y, m, n);
            dfs(arr, x, y-1, m, n);
            dfs(arr, x, y+1, m, n);
            return true;
        }

    }
}
