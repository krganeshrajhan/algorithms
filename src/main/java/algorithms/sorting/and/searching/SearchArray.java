package algorithms.sorting.and.searching;

public class SearchArray {

    static int searchRotatedArray(int arr[], int left, int right, int n) {
        int ind = Integer.MIN_VALUE;
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            if(arr[i] == n) {
                ind = i;
                break;
            }
        }
        return (ind == Integer.MIN_VALUE) ? -1 : (ind -left + length) % length;
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 0, 3, 5, 6};    // Given Array
        int left = 0;     // Starting Index of the Array
        int right = 6;    // Ending Index of the Array
        int n = 3;        // Key to Search
        System.out.println(searchRotatedArray(arr, left, right, n));
        System.out.println(searchRotatedArray(new int[]{5,6,7,1,2,3,4}, 0, 6, 0));
        System.out.println(searchRotatedArray(new int[]{2,2,2,2,4,5,3}, 0, 6, 2));
    }

}
