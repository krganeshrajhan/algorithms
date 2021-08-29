package algorithms.sorting;

import algorithms.sorting.helper.SortingHelper;

public class SelectionSort {

    public static void selectionSort(int[] arr, int arrSize) {
        for(int i = 0; i < arr.length; i++) {
            int minInd = SortingHelper.findMin(arr, i, arrSize);
            int buffer = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = buffer;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        selectionSort(arr, arr.length);
        SortingHelper.printArr(arr);
    }

}
