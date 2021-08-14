package algorithms.sorting;

import java.util.Arrays;

public class CheckSum {

    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];

        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int res = arr[i] + arr[j];
            if(res == n) {
                return new int[]{arr[i], arr[j]};
            } else if(res < n) {
                i++;
            } else {
                j--;
            }
        }

        return result; // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String[] args) {
        int[] arr = {1,21,3,14,5,60,7,6};
        int value = 81;
        int[] result = findSum(arr, value);
        Arrays.stream(result).forEach(value1 -> System.out.println(value1));
    }

}
