package leetcode;
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        return s.length() == t.length() && isAnagramComparedTo(s, t);
    }

    public static boolean isAnagramSolutionTwo(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }

        var map = new int[26];

        for(char x : s.toCharArray()) {
            map[x-'a']++;
        }

        for(char x : t.toCharArray()) {
            map[x-'a']--;
        }

        for(int i : map) {
            if (i!=0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAnagramComparedTo(String s, String t) {
        int lastTLength = t.length();

        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            t = t.replaceFirst(c, "");

            if (lastTLength == t.length()){
                return false;
            }

            lastTLength = t.length();
        }

        return t.isBlank();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagramSolutionTwo("anagram", "nagaram"));
    }
}
