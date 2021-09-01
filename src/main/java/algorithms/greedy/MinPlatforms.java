package algorithms.greedy;

public class MinPlatforms {

    public static int findPlatform(int[] arrival, int[] departure) {

        int maxTrains = 0;

        for(int i = 0; i < arrival.length; i++) {
            int count = 1;
            for(int j = i+1; j < arrival.length; j++) {
                if(arrival[j] >= arrival[i] && arrival[j] <= departure[i]) {
                    count++;
                }
            }
            maxTrains = Math.max(count, maxTrains);
        }
        return maxTrains;
    }

    public static void main(String[] args) {
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arrival, departure));
    }

}
