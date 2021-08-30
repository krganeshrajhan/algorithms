package algorithms.searching;

import java.util.HashSet;
import java.util.Set;

public class CheckSum {

    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int a : arr) {
            if(set.contains(n - a)) {
                return new int[]{n-a, a};
            }
            set.add(a);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,21,3,14,5,60,7,6};
        int value = 81;
        int[] findSum = findSum(arr, value);
        System.out.println(findSum[0] + " " + findSum[1]);
    }

}
