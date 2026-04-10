class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Set<Integer> st = new HashSet<>();
        for (int i : nums)
            st.add(i);
        int ans = 0;
        for (int i : st) {
            if (!st.contains(i - 1)) {
                int j = i + 1;
                while (st.contains(j))
                    j++;
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}