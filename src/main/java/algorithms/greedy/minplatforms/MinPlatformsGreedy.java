package algorithms.greedy.minplatforms;

import java.util.Arrays;

public class MinPlatformsGreedy {

    public static int findPlatform(int[] arrival, int[] departure) {
        int maxPlatforms = 1;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 1;
        int j = 0;
        int l = arrival.length;
        int platforms = 1;
        while(i < l && j < l) {
            if(arrival[i] < departure[j]) {
                platforms++;
                i++;
                maxPlatforms = Math.max(platforms, maxPlatforms);
            } else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arrival, departure));
    }

}
