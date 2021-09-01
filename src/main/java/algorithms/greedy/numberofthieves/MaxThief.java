package algorithms.greedy.numberofthieves;

import sun.tools.jconsole.inspector.IconManager;

import java.util.ArrayList;
import java.util.List;

public class MaxThief {

    public static int policeThief(char[] arr, int k) {
        int numberOfThieves = 0;
        List<Integer> cops = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') {
                cops.add(i);
            } else if(arr[i] == 'T') {
                thieves.add(i);
            }
        }
        int i = 0;
        int j = 0;
        while(i < cops.size() && j < thieves.size()) {
            if(Math.abs(cops.get(i) - thieves.get(j)) <= k) {
                numberOfThieves++;
                i++;
                j++;
                continue;
            } else if(thieves.get(j) < cops.get(i)) {
                j++;
            } else {
                i++;
            }
        }

        return numberOfThieves;
    }

    public static void main(String[] args) {
        int k, n;

        char policeTheifArray[] = {'P', 'T', 'T', 'P', 'T'};
        k = 2;

        System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + MaxThief.policeThief(policeTheifArray,k));

        char policeTheifArray1[] = {'T', 'T', 'P', 'P', 'T', 'P'};
        k = 2;

        System.out.println("Maximum thieves caught for {T, T, P, P, T,P}: " + MaxThief.policeThief(policeTheifArray1, k));
    }
}
