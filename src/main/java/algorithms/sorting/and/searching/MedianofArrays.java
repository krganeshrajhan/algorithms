package algorithms.sorting.and.searching;

public class MedianofArrays {

    public static double getMedian(int array1[], int array2[]) {
        int i = 0;
        int j = 0;
        int[] combinedArray = new int[array1.length + array2.length];
        int k = 0;
        while(i < array1.length && j < array2.length) {
            while(i == array1.length && j < array2.length) {
                combinedArray[k++] = array2[j++];
                continue;
            }
            while(j == array2.length && i < array1.length) {
                combinedArray[k++] = array1[i++];
            }
            if(array1[i] <= array2[j]) {
                combinedArray[k++] = array1[i++];
            } else {
                combinedArray[k++] = array2[j++];
            }
        }
        return (combinedArray.length % 2 == 0) ? ((combinedArray[(combinedArray.length/2) - 1] + combinedArray[combinedArray.length/2]) / 2) : combinedArray[combinedArray.length/2];
    }

    public static void main(String[] args) {
        int[] firstArray = {100};
        int[] secondArray = {1, 5, 8, 10, 20};
        double median = getMedian(firstArray, secondArray);
        System.out.println(median);
    }

}
