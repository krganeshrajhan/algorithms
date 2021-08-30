package algorithms.sorting.and.searching;

import algorithms.sorting.and.searching.helper.SortingHelper;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minInd = SortingHelper.findMin(arr, i);
            int buffer = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = buffer;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        selectionSort(arr);
        SortingHelper.printArr(arr);
    }

}
