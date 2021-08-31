package algorithms.dynamic.programming;

public class KnapsackProblemTopDown {

    public static int knapsackTopDown(int[][] lookupTable, int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int index) {
        knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, index);
        int maxProfit = 0;
        for(int i = 0 ; i < weightsLength; i++) {
            for(int j = 0; j <= capacity; j++) {
                maxProfit = Math.max(lookupTable[i][j], maxProfit);
            }
        }
        return maxProfit;
    }

    private static int knapsackRecursive(int[][] lookupTable, int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity, int index) {
        if(capacity < 0 || index == weightsLength || weights[index] > capacity) {
            return 0;
        }

        if(lookupTable[index][capacity] != 0) {
            return lookupTable[index][capacity];
        }

        int profit = 0;
        if(weights[index] <= capacity) {
            profit = profits[index] + knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity - weights[index], index + 1);
        }
        int nextProfit = knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, index + 1);
        lookupTable[index][capacity] = Math.max(profit, nextProfit);
        return lookupTable[index][capacity];
    }

    public static void main(String[] args) {
        int profit[] = {60, 100, 120};
        int profitsLength = 3;
        int weight[] = {10, 20, 30};
        int weightsLength = 3;
        int capacity = 50;
        int[][] lookupTable = new int[weightsLength][capacity + 1];
        System.out.println(knapsackTopDown(lookupTable, profit, profitsLength, weight, weightsLength, capacity, 0));
    }
}
