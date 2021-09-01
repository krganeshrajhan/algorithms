package algorithms.greedy;

import java.util.Arrays;

public class PipesWithMinimumCost {

    public static int minCost(int[] pipes) {
        Arrays.sort(pipes);
        int prevCost = 0;
        int cost = pipes[0];
        for(int i = 1; i < pipes.length; i++) {
            int curCost = cost + pipes[i];
            cost = curCost + prevCost;
            prevCost = curCost;
        }
        return cost;
    }

    public static void main(String[] args) {
        int [] pipes = {4, 2, 3, 7};
        System.out.println(minCost(pipes));
    }

}
