package com.bj.no1769;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int count = 0;

        while(num.length() > 1){
            Main myMain = new Main();
            num = myMain.splitAndSum(num);
            count++;
        }

        System.out.println(count);

        if (Integer.parseInt(num)%3 == 0){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

    public String splitAndSum(String stringNumber){
        long sum = 0;
        for (int i = 0; i < stringNumber.length(); i++ ) {
            sum += Integer.parseInt((stringNumber.substring(i,i+1)));
        }
        return Long.toString(sum);
    }
}