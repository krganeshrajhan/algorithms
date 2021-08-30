package algorithms.sorting.and.searching;

public class SearchMatrix {

    public static boolean findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int min = 0;
        int max = numberOfRows * numberOfColumns - 1;
        while( min <= max) {
            int mid = (min + max) / 2;
            int row = mid / numberOfColumns;
            int col = mid % numberOfColumns;
            if(target < matrix[row][col]) {
                max = mid - 1;
            } else if(target > matrix[row][col]) {
                min = mid + 1;
            } else {
                return true;
            }
        }
        return false;
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
