package algorithms.sorting.and.searching.basics;

import algorithms.sorting.and.searching.helper.SortingHelper;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        bubbleSort(arr, arr.length);
        SortingHelper.printArr(arr);
    }

    private static void bubbleSort(int[] arr, int length) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
