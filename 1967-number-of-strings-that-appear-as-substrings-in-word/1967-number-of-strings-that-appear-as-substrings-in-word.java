class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pat : patterns) {
            if (kmpSearch(word, pat)) ans++;
        }
        return ans;
       
    }
    private boolean kmpSearch(String text, String pat) {
        int n = text.length(), m = pat.length();
        if (m > n) return false;
        if (m == 0) return true;

        int[] lps = buildLPS(pat);
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == m) return true; 
            } else if (j > 0) {
                j = lps[j - 1]; 
            } else {
                i++;
            }
        }
        return false;
    }

   
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}