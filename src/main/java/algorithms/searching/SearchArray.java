package algorithms.searching;

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
        return (ind -left + length) % length;
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 0, 3, 5, 6};    // Given Array
        int left = 0;     // Starting Index of the Array
        int right = 6;    // Ending Index of the Array
        int n = 3;        // Key to Search
        System.out.println(searchRotatedArray(arr, left, right, n));
    }

}
