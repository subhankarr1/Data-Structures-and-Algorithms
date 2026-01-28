class Solution {
    public String lexSmallestAfterDeletion(String s) {
        int[] freq = new int[26];
        int[] cnt = new int[26];
        StringBuilder ss = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char curr : s.toCharArray()) {
            freq[curr - 'a']--;

            while (ss.length() > 0) {
                char last = ss.charAt(ss.length() - 1);
                if (last > curr && (freq[last - 'a'] > 0 || cnt[last - 'a'] > 1)) {
                    ss.deleteCharAt(ss.length() - 1);
                    cnt[last - 'a']--;
                } 
                else break;
            }
            ss.append(curr);
            cnt[curr - 'a']++;
        }
        while(ss.length() > 0) {
            char last = ss.charAt(ss.length() - 1);
            if(cnt[last - 'a'] > 1) {
                ss.deleteCharAt(ss.length() - 1);
                cnt[last - 'a']--;
            }
            else break;
        }
        return ss.toString();
    }
}