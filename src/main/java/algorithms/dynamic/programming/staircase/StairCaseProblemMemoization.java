package algorithms.dynamic.programming.staircase;

public class StairCaseProblemMemoization {

    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
    }

    private static int countWays(int i) {
        int[] lookupTable = new int[i+1];
        countWaysRec(i, lookupTable);
        return lookupTable[i];
    }

    private static int countWaysRec(int n, int[] lookupTable) {
        if(n < 0) {
            return 0;
        } else if(lookupTable[n] != 0) {
            return lookupTable[n];
        } else if(n == 0) {
            return 1;
        } else {
            lookupTable[n] = countWaysRec(n-1, lookupTable) + countWaysRec(n-2, lookupTable) + countWaysRec(n-3, lookupTable);
        }
        return lookupTable[n];
    }
}
