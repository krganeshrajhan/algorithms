package algorithms.sorting.and.searching;

import algorithms.sorting.and.searching.helper.Helper;
import algorithms.sorting.and.searching.helper.SortingHelper;

public class DutchNationalFlag {

    public static void dutchNationalFlag(int [] arr) {
        int i = 0;
        int mid = 0;
        int j = arr.length - 1;

        while (mid < j) {
            if(arr[mid] == 0) {
                Helper.swap(arr, i++, mid++);
            } else if(arr[mid] == 2) {
                Helper.swap(arr, j--, mid++);
            } else {
                i++;
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 1, 2, 1, 0};
        dutchNationalFlag(arr);
        SortingHelper.printArr(arr);
    }

}
