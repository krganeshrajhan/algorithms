package algorithms.dynamic.programming.shortestcommonsubsequence;

public class SCS {

    public static int findSCSLength(String str1, String str2) {
        int[][] lookupTable = new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i <= str1.length(); i++)
            lookupTable[i][0] = i;
        for (int j = 0; j <= str2.length(); j++)
            lookupTable[0][j] = j;


        for(int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    lookupTable[i][j] = 1 + lookupTable[i-1][j-1];
                } else {
                    lookupTable[i][j] = 1 + Math.min(lookupTable[i-1][j], lookupTable[i][j-1]);
                }
            }
        }

        return lookupTable[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(findSCSLength("abcdz", "bdcf"));
        System.out.println(findSCSLength("educative", "educative.io"));
    }
}
