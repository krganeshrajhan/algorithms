package algorithms.dynamic.programming.longestpalindromicsequence;

public class LPSBottomUp {

    public static void main(String[] args) {
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("abdbca"));
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("pqr"));
    }

    private static int LPSLength(String str) {
        int[][] lookupTable = new int[str.length()][str.length()];

        for(int i = 0; i < str.length(); i++) {
            lookupTable[i][i] = 1;
        }

        for(int i = str.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    lookupTable[i][j] = 2 + lookupTable[i+1][j-1];
                } else {
                    lookupTable[i][j] = Math.max(lookupTable[i+1][j], lookupTable[i][j-1]);
                }
            }
        }
        return lookupTable[0][str.length() - 1];
    }
}
