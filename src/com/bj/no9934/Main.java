package com.bj.no9934;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        var k = sc.nextInt();
        var k2 = sc.nextLine();
        var building = sc.nextLine().split(" ");


        for (int i=0; i<2000; i++){
            result[i] = new ArrayList<>();
        }

        Main main = new Main();
        main.binary(building);


        var index = building.length;
        for (int i=0; i<k; i++){
            for(String r: result[index]){
                System.out.print(r + " ");
            }
            System.out.println("");
            index = index/2;
        }

//        for (var r: result){
//            System.out.println(r);
//        }
    }

    public static ArrayList<String>[] result = new ArrayList[2000];

    public void binary(String[] target){
//        System.out.println(target.length);
        if (target.length < 2){
            result[1].add(target[0]);
            return;
        }
        var border = target.length/2;
        result[target.length].add(target[border]);
//        System.out.println(target[border]);
        var targetLeft = new String[border];
        var targetRight = new String[border];
        for(int i=0; i<border; i++){
            targetLeft[i] = target[i];
            targetRight[i] = target[i+border+1];
        }
        binary(targetLeft);
        binary(targetRight);

    }
}
