package algorithms.dynamic.programming;

public class FibonacciTabulated {

    public static int fib(int n, int[] lookupTable)
    {
        lookupTable[0] = 0;
        lookupTable[1] = 1;

        for(int i = 2; i <= n; i++) {
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2];
        }

        return lookupTable[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] lookupTable = new int[n+1];
        System.out.print(fib(n, lookupTable));
    }

}
