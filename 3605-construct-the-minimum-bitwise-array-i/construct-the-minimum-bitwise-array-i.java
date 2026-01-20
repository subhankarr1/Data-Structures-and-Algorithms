class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int i = 0;
        for(int n : nums) {
            if(n == 2) {
                ans[i] = -1;
            }
            else {
                int mask = ~(((n+1) & ~n) >> 1);
                ans[i] = n & mask;
            }
            i++;
        }
        return ans;
    }
}