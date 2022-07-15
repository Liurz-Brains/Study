package wordmultiple;

import java.util.*;

public class word {
    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        int begin = 0;
        int maxsize = 1;
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            int ou = panduan(array, i, i);
            int ji = panduan(array, i, i + 1);
            int current = Math.max(ji, ou);
            if (current > maxsize) {
                maxsize = current;
                begin = i- ((maxsize-1)>>1);
            }
        }
        return s.substring(begin, begin + maxsize);
    }

    public static int panduan(char[] array, int i, int j) {
        int length = 0;
        while (i >= 0 && j < array.length) {
            if (array[i--] == array[j++])
                length = j - i - 1;
            else
                break;
        }
        return length;
    }
    public static void main(String[] args) {
/*        Scanner sca = new Scanner(System.in);
        String s = sca.next();*/
        String s = "abcbakljfdgd";
        System.out.println(longestPalindrome(s));
    }
}
