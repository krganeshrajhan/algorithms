package algorithms.dynamic.programming.coinchange;

public class CoinChange {

    public static int countChange(int[] denoms, int denomsLength, int amount) {
        System.out.println("starting denomslength: " + denomsLength + " , amount: " + amount);
        if(amount == 0) {
            System.out.println("Amount = 0, denomsLength: " + denomsLength);
            return 1;
        }

        if(amount < 0 || denomsLength <= 0) {
            System.out.println("Amount:" + amount + ", denomsLength: " + denomsLength);
            return 0;
        }

        if(denomsLength <= 0 && amount>= 1) {
            System.out.println("Amount:" + amount + ", denomsLength: " + denomsLength);
            return 0;
        }

        int onelessDenoms = countChange(denoms, denomsLength - 1, amount);
        int reduceAmount = countChange(denoms, denomsLength, amount - denoms[denomsLength - 1]);
        System.out.println(onelessDenoms + " " + reduceAmount);
        return onelessDenoms + reduceAmount;
    }

    public static void main(String[] args) {
        int amount = 10;
        int[] denoms = new int[]{25,10,5,1};
        System.out.println(countChange(denoms, 4, amount));
    }

}
