package algorithms.sorting;

import algorithms.sorting.helper.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        mergeSort(arr, 0, arr.length-1);
        SortingHelper.printArr(arr);
    }

    private static void mergeSort(int[] arr, int leftInd, int rightInd) {
        if(leftInd >= rightInd) {
            return;
        }
        int mid = leftInd + (rightInd - leftInd) / 2;

        mergeSort(arr, leftInd, mid);
        mergeSort(arr, mid+1, rightInd);

        merge(arr, leftInd, mid, rightInd);
    }

    private static void merge(int[] arr, int leftInd, int mid, int rightInd) {
        int i = 0;
        int j = 0;
        int k = leftInd;

        int[] leftArr = Arrays.copyOfRange(arr, leftInd, mid+1);
        int[] rightArr = Arrays.copyOfRange(arr, mid+1, rightInd + 1);

        while( i < leftArr.length || j < rightArr.length) {
            if(i == leftArr.length) {
                arr[k++] = rightArr[j++];
                continue;
            }
            if(j == rightArr.length) {
                arr[k++] = leftArr[i++];
                continue;
            }
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
                continue;
            } else {
                arr[k++] = rightArr[j++];
                continue;
            }
        }
    }

}
