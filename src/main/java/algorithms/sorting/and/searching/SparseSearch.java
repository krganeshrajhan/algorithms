package algorithms.sorting.and.searching;

public class SparseSearch {

    public static void main(String[] args) {
        String [] array = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
        String [] targetArray = {"educative", "learning"};

        for(int i = 0; i < 2; i++) {
            System.out.println(targetArray[i] + ": " + searchForString(array, targetArray[i]));
        }
    }

    private static int searchForString(String[] array, String s) {
        return modifiedBinarySearch(array, 0, array.length - 1, s);
    }

    private static int modifiedBinarySearch(String[] array, int start, int end, String target) {

        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if(array[mid].equals("")) {
            int i = mid - 1;
            int j = mid + 1;
            while(true) {
                if(i < start && j == array.length) {
                    return -1;
                }
                if(i >= start && !array[i].equals("")) {
                    mid = i;
                    break;
                } else if (j <= end && !array[j].equals("")) {
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }

        while(true) {
            if(array[mid].compareTo(target) > 0) {
                return modifiedBinarySearch(array, start, mid - 1, target);
            } else if(array[mid].compareTo(target) < 0) {
                return modifiedBinarySearch(array, mid + 1, end, target);
            } else {
                return mid;
            }
        }
    }


}
