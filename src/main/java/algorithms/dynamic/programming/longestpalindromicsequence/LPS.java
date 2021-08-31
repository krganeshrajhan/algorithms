package algorithms.dynamic.programming.longestpalindromicsequence;

public class LPS {

    public static void main(String[] args) {
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("abdbca"));
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("pqr"));
    }

    private static int LPSLength(String str) {
        int length = str.length();
        int left = 0;
        int right = str.length() - 1;
        return lpsRecursive(str, left, right);
    }

    private static int lpsRecursive(String str, int left, int right) {

        if(left > right) {
            return 0;
        }

        if(left == right) {
            return 1;
        }

        if(str.charAt(left) == str.charAt(right)) {
            return 2 + lpsRecursive(str, left + 1, right - 1);
        }
        int countAfter = lpsRecursive(str, left + 1, right);
        int countBefore = lpsRecursive(str, left, right - 1);
        return Math.max(countBefore, countAfter);
    }

}
