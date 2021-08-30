package algorithms.sorting.and.searching.helper;

public class SortingHelper {

    public static void printArr(int[] arr) {
        for(int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int findMin(int[] arr, int start) {
        int min = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = start; i < arr.length; i++) {
            if(arr[i] < minValue) {
                min = i;
                minValue = arr[i];
            }
        }
        return min;
    }
}
