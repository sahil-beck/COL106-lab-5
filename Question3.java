import java.util.Arrays;

public class Question3 {
    public static String longestCommonPrefix(String[] strings) {
        String ans = "";
        Arrays.sort(strings);
        for (int i = 0, n = Math.min(strings[0].length(), strings[strings.length - 1].length()); i < n; i++) {
            if (strings[0].charAt(i) != strings[strings.length - 1].charAt(i)) break;
            ans += strings[0].charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // test cases
        String[] strings = {"abcdefgh", "abcefgh"}; // TC1
        // String[] strings = {"abcdefgh", "aefghijk", "abcefgh"}; // TC2
        // String[] strings = {"sadadadaghjt", "sadadadaghjt", "sadadaghjt", "sadadadadadadaghjt"}; // TC3
        System.out.println(longestCommonPrefix(strings));
    }
}
