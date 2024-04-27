public class Question5 {
    public static int findCount (String s, String p) {
        int ans = 0, len = p.length(), lps[] = new int[p.length() + s.length() + 1];
        p += '#' + s;
        lps[0] = 0;
        for (int i = 1, j; i < p.length(); i++) {
            j = lps[i - 1];
            while (p.charAt(i) != p.charAt(j)) {
                if (j == 0) break;
                j = lps[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) j++;
            lps[i] = j;
            if (lps[i] == len) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // test cases
        String s = "AABAACAADAABAABA", p = "AABA"; // TC1
        // String s = "AAAAAAAAAA", p = "AAA"; // TC2
        // String s = "heyhihey", p = "heyi"; // TC3
        System.out.println(findCount(s, p));
    }
}
