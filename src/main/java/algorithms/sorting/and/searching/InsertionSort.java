package algorithms.sorting.and.searching;

import algorithms.sorting.and.searching.helper.SortingHelper;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        insertionSort(arr, arr.length);
        SortingHelper.printArr(arr);
    }

    private static void insertionSort(int[] arr, int length) {
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int el = arr[i];
            while(j >= 0 && arr[j] > el) {
                int temp = arr[j];
                arr[j] = el;
                arr[j+1] = temp;
                j--;
            }
        }
    }

}
