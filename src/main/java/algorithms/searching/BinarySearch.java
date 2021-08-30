package algorithms.searching;

import algorithms.sorting.helper.SortingHelper;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {-100,0,0,1,4,4,5,5,95,200};
        int index = binarySearch(1, arr, arr.length);
        SortingHelper.printArr(arr);
        System.out.println(index);
        index = binarySearch(6, arr, arr.length);
        System.out.println(index);
    }

    private static int binarySearch(int key, int[] arr, int length) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(key < arr[mid]) {
                end = mid - 1;
            } else if(key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
