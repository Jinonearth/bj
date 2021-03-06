package com.bj.no2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        var condition = br.readLine().split(" ");
        var n = Integer.parseInt(condition[0]);
        var m = Integer.parseInt(condition[1]);
        int [][] arr = new int[n][m];
        for (int y=0; y<n; y++){
            var row = br.readLine();
            for (int x=0; x<m; x++){
                arr[y][x] = Integer.parseInt(row.substring(x, x+1));

            }
        }

        Main main = new Main();
        System.out.println(main.result(arr, m, n));
    }

    public int[][] cost;

    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};


    public int result(int[][] arr, int m, int n){
        this.cost = new int[n][m];
        for (int x=0; x<m; x++){
            for (int y=0; y<n; y++){
                cost[y][x] = -1;
                }
            }

        bfs(arr, m, n);

        return cost[n-1][m-1];
    }

    public void bfs(int[][] arr, int m, int n){

        cost[0][0] = 1;

        ArrayDeque<Pair> Queue = new ArrayDeque<>();

        Queue.addLast(new Pair(0,0));

        while (!Queue.isEmpty()){
            var location = Queue.removeFirst();
            var x = location.x;
            var y = location.y;

            for (int i=0; i<4; i++){
                var nx = x + dx[i];
                var ny = y + dy[i];

                if (nx<0|| ny<0 || nx>=m || ny>=n){
                    continue;
                }

                if (cost[ny][nx] != -1 || arr[ny][nx] == 0){
                    continue;
                }

                cost[ny][nx] = cost[y][x] + 1;

                Queue.addLast(new Pair(nx, ny));
            }
        }


    }

    static class Pair {
        int y;
        int x;

        public Pair(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
}
