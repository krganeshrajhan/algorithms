package algorithms.sorting.and.searching;

public class SearchInsert {

    public static int insertPosition(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(target < arr[mid]) {
                if(start == mid || target > arr[mid -1]) {
                    return mid;
                }
                end = mid -1;
            } else if(target > arr[mid]) {
                if(end == mid || target < arr[mid+1]) {
                    return mid;
                }
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,6};
        int target = 5;
        System.out.println(insertPosition(arr, target));
    }

}
