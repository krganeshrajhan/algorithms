package algorithms.greedy;

public class MaxNumber {

    public static int findLargestNumber(int number_of_digits, int sum_of_digits ) {
        int largestNumber = 0;

        while(number_of_digits > 0) {
            for(int i = 9; i >= 0; i--) {
                double num = i * Math.pow(10, number_of_digits - 1);
                if((sum_of_digits - i) >= 0) {
                    largestNumber += num;
                    sum_of_digits -= i;
                    number_of_digits--;
                    break;
                }
            }
        }
        return largestNumber;
    }

    public static void main(String[] args) {
        int number_of_digits = 3, sum_of_digits = 20;
        System.out.println(findLargestNumber(number_of_digits, sum_of_digits));
    }

}
