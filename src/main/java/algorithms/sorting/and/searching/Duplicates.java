package algorithms.sorting.and.searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static ArrayList< Integer > findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for(int a : arr) {
            if (set.contains(a)) {
                duplicates.add(a);
            }
            set.add(a);
        }
        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};
        ArrayList<Integer> duplicates = findDuplicates(arr);
        duplicates.stream().forEach(integer -> System.out.println(integer));
    }

}
