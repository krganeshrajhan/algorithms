package algorithms.dynamic.programming.staircase;

public class StairCaseProblemTabularization {

    public static int countWays(int n) {
        int[] lookupTable = new int[n+1];
        lookupTable[0] = 1;
        lookupTable[1] = 1;
        lookupTable[2] = 2;

        for(int i = 3; i < n; i++) {
            lookupTable[n] = lookupTable[n-1] + lookupTable[n-2] + lookupTable[n-3];
        }

        return lookupTable[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
    }

}
