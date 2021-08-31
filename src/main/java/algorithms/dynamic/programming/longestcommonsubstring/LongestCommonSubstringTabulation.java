package algorithms.dynamic.programming.longestcommonsubstring;

public class LongestCommonSubstringTabulation {

    public static void main(String[] args) {
        String S1 = "www.educative.io/explore";
        String S2 = "educative.io/edpresso";
        String S3 = "0abc321";
        String S4 = "123abcdef";
        System.out.println(longestCommonSubstrLength(S3, S4));
        System.out.println(longestCommonSubstrLength(S1, S2));
    }

    private static int longestCommonSubstrLength(String s1, String s2) {
        int[][] lookupTable = new int[s1.length()+1][s2.length()+1];

        int maxLength = 0;
        for(int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookupTable[i][j] = 1 + lookupTable[i-1][j-1];
                    maxLength = Math.max(maxLength, lookupTable[i][j]);
                }
            }
        }
        return maxLength;
    }

}
