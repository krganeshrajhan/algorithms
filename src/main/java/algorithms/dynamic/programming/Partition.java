package algorithms.dynamic.programming;

import java.util.Arrays;

public class Partition {

    public static boolean canPartition(int[]num) {
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        return canPartitionRec(num, 0, sum/2);
    }

    private static boolean canPartitionRec(int[] num, int index, int sum) {

        if(sum == 0) {
            return true;
        }

        if(num.length == 0 || index == num.length) {
            return false;
        }

        if(num[index] <= sum) {
            if(canPartitionRec(num, index + 1, sum - num[index])) {
                return true;
            }
        }
        return canPartitionRec(num, index + 1, sum);
    }

    public static void main(String[] args) {
        int set1[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(set1) + "\t--->\t" + canPartition(set1));
        int set2[] = {1, 1, 3, 4, 7};
        System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
        int set3[] = {2, 3, 4, 6};
        System.out.println(Arrays.toString(set3) + "\t--->\t" + canPartition(set3));
    }

}
