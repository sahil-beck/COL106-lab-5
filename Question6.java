public class Question6 {
    private static int findCount (String s) {
        int lps[] = new int[2 * s.length() + 1], maxLps = 0;
        s += '#';
        for (int i = s.length() - 2; i >= 0; i--) s += s.charAt(i); 
        lps[0] = 0;
        for (int i = 1, j; i < s.length(); i++) {
            j = lps[i - 1];
            while (s.charAt(i) != s.charAt(j)) {
                if (j == 0) break;
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            lps[i] = j;
            if (lps[i] > maxLps) maxLps = lps[i];
        }
        return s.length() / 2 - maxLps;
    }

    public static void main(String[] args) {
        // test cases
        String s = "aacecaaa"; // TC1
        // String s = "abcd"; // TC2
        // String s = "aaaaaaa"; // TC3
        System.out.println(findCount(s));
    }
}
