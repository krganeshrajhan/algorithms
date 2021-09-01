package algorithms.greedy.knapsack;

import java.util.*;

public class FractionalKnapsack {

    public static double getMaxValue(double[] w, double[] v, double c) {
        SortedMap<Double, List<Integer>> fractionalMap = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0; i < v.length; i++) {
            double fraction = v[i] / w[i];
            List<Integer> list = fractionalMap.getOrDefault(fraction, new ArrayList<>());
            list.add(i);
            fractionalMap.put(fraction, list);
        }
        double totalValues = 0;
        for(SortedMap.Entry<Double, List<Integer>> entry : fractionalMap.entrySet()) {
            for (int i : entry.getValue()) {
                if (w[i] > 0 && c > 0) {
                    double consumableFraction = Math.min(c, w[i]);
                    double value = v[i] * ((consumableFraction) / w[i]);
                    v[i] -= value;
                    totalValues += value;
                    c -= consumableFraction;
                    w[i] -= consumableFraction;
                }
            }
        }
        return totalValues;
    }

    public static void main(String[] args) {
        double[] weights = {2, 1, 6, 0.5, 0.25, 7};
        double[] values = {50, 70, 100, 50, 30, 99};
        int capacity = 10;
        System.out.println(getMaxValue(weights, values, capacity));
    }

}
