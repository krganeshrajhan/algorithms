package algorithms.sorting.and.searching;

public class SearchMatrix {

    public static boolean findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        for(int i = 0; i < numberOfRows; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][numberOfColumns-1]) {
                return binarySearch(matrix, i, 0, numberOfColumns-1, target);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int row, int start, int end, int target) {
        int mid = (start + end + 1) / 2;
        if(matrix[row][mid] < target) {
            if(mid == end) {
                return false;
            }
            return binarySearch(matrix, row, mid+1, end, target);
        } else if(matrix[row][mid] > target) {
            if(mid == start) {
                return false;
            }
            return binarySearch(matrix, row, start, mid-1, target);
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{10, 11, 12, 13},
                new int[]{14, 15, 16, 17},
                new int[]{27, 29, 30, 31},
                new int[]{32, 33, 39, 80}};
        boolean isFound = findKey(matrix, matrix.length, matrix[0].length, 30);
        System.out.println(isFound);
        System.out.println(findKey(matrix, matrix.length, matrix[0].length, 32));
        System.out.println(findKey(matrix, matrix.length, matrix[0].length, 42));
    }
}
