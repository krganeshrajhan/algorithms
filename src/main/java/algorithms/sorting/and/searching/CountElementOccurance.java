package algorithms.sorting.and.searching;

public class CountElementOccurance {

    public static int calcFreq(int arr[], int key) {
        return binarySearch(arr, key, 0, arr.length-1);
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        if(start > end || start < 0 || end == arr.length) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (key < arr[mid]) {
            return binarySearch(arr, key, start, mid-1);
        } else if(key > arr[mid]) {
            return binarySearch(arr, key, mid+1, end);
        } else {
            return binarySearch(arr, key, start, mid-1) + 1 + binarySearch(arr, key, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = {-5,-3,0,1,3,3,3,4,5};
        int s = 3;
        System.out.println(calcFreq(arr, s));
    }
}
