package algorithms.dynamic.programming.knapsack;

public class KnapsackProblem {

    public static int knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int index) {

        if(capacity < 0 || index == weightsLength || weights[index] > capacity) {
            return 0;
        }

        int profit = 0;
        if(weights[index] <= capacity) {
            profit = profits[index] + knapsack(profits, profitsLength, weights, weightsLength, capacity - weights[index], index + 1);
        }

        int nextProfit = knapsack(profits, profitsLength, weights, weightsLength, capacity, index + 1);
        return Math.max(profit, nextProfit);
    }

    public static void main(String[] args) {
        int profit[] = {60, 100, 120};
        int profitsLength = 3;
        int weight[] = {10, 20, 30};
        int weightsLength = 3;
        int capacity = 50;
        System.out.println(knapsack(profit, profitsLength, weight, weightsLength, capacity, 0));
    }

}
