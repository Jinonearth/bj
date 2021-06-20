package com.bj.no1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static int[] dist;
    public static int[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var line = br.readLine().split(" ");
        var n = Integer.parseInt(line[0]);
        var e = Integer.parseInt(line[1]);
        var adjList = new ArrayList<ArrayList<Node>>();
        for (int i=0; i<=n+1; i++){
            adjList.add(i, new ArrayList<Node>());
        }
        for (int i=0; i<e; i++){
            line = br.readLine().split(" ");
            var a = Integer.parseInt(line[0]);
            var b = Integer.parseInt(line[1]);
            var d = Integer.parseInt(line[2]);
            adjList.get(a).add(new Node(b, d));
            adjList.get(b).add(new Node(a, d));
        }

        line = br.readLine().split(" ");
        var n1 = Integer.parseInt(line[0]);
        var n2 = Integer.parseInt(line[1]);

        dijkstra(n, 1, adjList);
        var d1n1 = dist[n1];
        var d1n2 = dist[n2];
        dijkstra(n, n1, adjList);
        var n1n2 = dist[n2];
        var n1n = dist[n];
        dijkstra(n, n2, adjList);
        var n2n = dist[n];

        if (Math.min(d1n1 + n1n2 + n2n , d1n2 + n1n2 + n1n) >= 10000000){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(d1n1 + n1n2 + n2n , d1n2 + n1n2 + n1n));
        }

    }

    public static void dijkstra(int n, int start, ArrayList<ArrayList<Node>> adjlist){
        dist = new int[n+1];
        visited = new int[n+1];

        for (int i=0; i<=n; i++){
            dist[i] = 10000000;
            dist[start] = 0;
            visited[i] = 0;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist-o2.dist;
            }
        });
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            var node = pq.poll();
            if (visited[node.node] == 1){
                continue;
            }
            for (Node nn: adjlist.get(node.node)){
//                System.out.println(nn.node);
                if (nn.dist + dist[node.node] < dist[nn.node]){
                    dist[nn.node] = nn.dist + dist[node.node];
                    pq.add(new Node(nn.node, dist[nn.node]));

                }
            }
            visited[node.node] = 1;
        }
    }

    public static class Node{
        public int node;
        public int dist;
        public Node (int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
