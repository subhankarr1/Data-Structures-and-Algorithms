class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length(), len = 0;
        HashMap<Character, Integer> st = new HashMap<>();
        while(r < n) {
            if(st.containsKey(s.charAt(r))) {
                l = Math.max(l, st.get(s.charAt(r)) + 1);
            }
            st.put(s.charAt(r), r);
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}