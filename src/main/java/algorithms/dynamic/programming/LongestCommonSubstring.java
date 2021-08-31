package algorithms.dynamic.programming;

public class LongestCommonSubstring {

    public static int LCSLength(String s1, String s2) {
        int longest = -1;
        longest = getLongest(s1, s2, longest);
        longest = getLongest(s2, s1, longest);
        return longest;
    }

    private static int getLongest(String s1, String s2, int longest) {
        for(int i = 0; i < s1.length(); i++) {
            int index2 = 0;
            while((index2 = s2.indexOf(Character.toString(s1.charAt(i)), index2)) >= 0) {
                int length = findLongest(s1, i, s2, index2);
                longest = Math.max(longest, length);
                index2 += length;
            }
        }
        return longest;
    }

    private static int findLongest(String s1, int index, String s2, int index2) {
        int length = 0;
        int i = index;
        int j = index2;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                length++;
                i++;
                j++;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String string1 = "www.educative.io/explore";
        String string2 = "educative.io/edpresso";
        System.out.println(LCSLength(string1, string2));
    }

}
