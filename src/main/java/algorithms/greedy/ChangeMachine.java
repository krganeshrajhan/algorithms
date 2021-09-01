package algorithms.greedy;

import java.util.ArrayList;

public class ChangeMachine {


    public static int[] coins = {25, 10, 5, 1};

    public static ArrayList< Integer > getMinCoins(int amount) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        while(amount > 0) {
            while(amount >= coins[i]) {
                list.add(coins[i]);
                amount -= coins[i];
            }
            i++;
        }

        return list;
    }

    public static void main(String[] args) {
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));
        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));
        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));
        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }

}
