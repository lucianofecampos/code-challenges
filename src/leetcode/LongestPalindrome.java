package leetcode;

import java.util.Comparator;
import java.util.stream.Stream;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }

        String longestPalindrome = "";

        for(int i = 0; i < s.length(); i++) {
            longestPalindrome = pickLongestPalindrome(
                    longestPalindrome,
                    checkAndGetPalindrome(s, i, i),
                    checkAndGetPalindrome(s, i, i+1)
            );
        }

        return longestPalindrome;
    }

    public static String pickLongestPalindrome(String... palindromes) {
        return Stream.of(palindromes)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static String checkAndGetPalindrome(String s, int j, int k) {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        return s.substring(j + 1,  k);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
