package com.bj.no1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        var t = Integer.parseInt(br.readLine());

        int[] result = new int[t];
        Main main = new Main();
        for (int i = 0; i < t; i++) {
            var condition = br.readLine().split(" ");
            var m = Integer.parseInt(condition[0]);
            var n = Integer.parseInt(condition[1]);
            var k = Integer.parseInt(condition[2]);
            int[][] arr = new int[n][m];
            for (int r=0; r < k; r++){
                var value = br.readLine().split(" ");
                var x = Integer.parseInt(value[0]);
                var y = Integer.parseInt(value[1]);
                arr[y][x] = 1;
            }
        result[i] = main.solve(arr, m, n);

        }
        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }

    public int[][] visited;

    public int solve(int[][] arr, int m, int n) {
        visited = new int[n][m];
        int count = 0;
        for (int x=0; x<m; x++){
            for (int y=0; y<n; y++){
                if (dfs(arr, x, y, m, n)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] arr, int x, int y, int m, int n){
        if (x < 0 || y < 0 || x >= m || y >= n){
            return false;
        }
        else {
            if (visited[y][x] == 0 && arr[y][x] == 1) {
                visited[y][x] = 1;
                dfs(arr, x + 1, y, m, n);
                dfs(arr, x - 1, y, m, n);
                dfs(arr, x, y + 1, m, n);
                dfs(arr, x, y - 1, m, n);
                return true;
            } else {
                return false;
            }
        }
    }
}
