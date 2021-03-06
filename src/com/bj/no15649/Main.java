package com.bj.no15649;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] Args){
        Scanner sc = new Scanner(System.in);
        var numberPool = sc.nextInt();
        var selectNumber = sc.nextInt();

        Main main = new Main();
        main.numberSelection(numberPool, selectNumber);
    }

    public ArrayList<String> result = new ArrayList<>();

    public void numberSelection(int numberPool, int selectNumber){

        ArrayList<Integer> selectedNumberCollection = new ArrayList<>();
        ArrayList<Integer> selectedNumberCheck = new ArrayList<>();

        for (int i=0; i<=numberPool; i++){
            selectedNumberCheck.add(0);
        }

        int nextSelectNumber = selectNumber;

        savePoint(selectedNumberCollection, selectedNumberCheck, nextSelectNumber);

        for (var r: result){
            System.out.println(r);
        }

    }

    public void savePoint(ArrayList<Integer> selectedNumberCollection, ArrayList<Integer> selectedNumberCheck, int nextSelectNumber){
        StringBuilder sb = new StringBuilder();


        if (nextSelectNumber == 0){
            for ( var r : selectedNumberCollection){
                sb.append(r);
                sb.append(" ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i=1; i<selectedNumberCheck.size(); i++){
            if (selectedNumberCheck.get(i) == 0) {
                selectedNumberCollection.add(i);
                selectedNumberCheck.set(i, 1);
                savePoint(selectedNumberCollection, selectedNumberCheck, nextSelectNumber-1);
                selectedNumberCheck.set(i, 0);
                selectedNumberCollection.remove(selectedNumberCollection.size()-1);
            }
        }
    }
}
