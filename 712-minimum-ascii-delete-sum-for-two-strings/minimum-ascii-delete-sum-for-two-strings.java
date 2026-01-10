class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int j = 1; j <= m; j++) prev[j] =prev[j-1] + s2.charAt(j-1);

        for(int i = 1; i <= n; i++) {
            curr[0] = prev[0] + s1.charAt(i-1);
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) curr[j] = prev[j-1];
                else curr[j] = Math.min(prev[j] + s1.charAt(i-1), curr[j-1] + s2.charAt(j-1));
            }
            prev = curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}