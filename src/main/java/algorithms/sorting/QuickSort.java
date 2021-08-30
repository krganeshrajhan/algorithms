package algorithms.sorting;

import algorithms.sorting.helper.SortingHelper;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        quickSort(arr, 0, arr.length-1);
        SortingHelper.printArr(arr);
    }

    private static void quickSort(int[] arr, int leftInd, int rightInd) {

        if(leftInd >= rightInd) {
            return;
        }

        int pivotInd = leftInd + (rightInd - leftInd) / 2;
        int pivot = arr[pivotInd];

        swap(arr, pivotInd, rightInd);
        int maxLeft = leftInd;
        int minRight = rightInd-1;
        while(minRight > maxLeft) {
            maxLeft = findFirstMax(arr, 1, pivot, leftInd);
            minRight = findFirstMin(arr, -1, pivot, rightInd-1);
            if(minRight > maxLeft) {
                swap(arr, maxLeft, minRight);
            } else {
                swap(arr, maxLeft, rightInd);
            }
        }

        quickSort(arr, leftInd, maxLeft-1);
        quickSort(arr, maxLeft+1, rightInd);
    }

    private static int findFirstMax(int[] arr, int flag, int pivot, int index) {
        if(flag > 0) {
            for(int i = index; i < arr.length; i++) {
                if(arr[i] > pivot) {
                    return i;
                }
            }
        } else {
            for(int i = index; i >= 0; i--) {
                if(arr[i] > pivot) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int findFirstMin(int[] arr, int flag, int pivot, int index) {
        if(flag > 0) {
            for(int i = index; i < arr.length-1; i++) {
                if(arr[i] < pivot) {
                    return i;
                }
            }
        } else {
            for(int i = index; i >= 0; i--) {
                if(arr[i] < pivot) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int leftInd, int rightInd) {
        int temp = arr[leftInd];
        arr[leftInd] = arr[rightInd];
        arr[rightInd] = temp;
    }

}
