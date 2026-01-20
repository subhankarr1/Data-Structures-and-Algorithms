class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int a = nums.get(i);
            for(int j = 0; j < a; j++) {
                if((j | (j+1)) == a) {
                    ans[i] = j;
                    break;
                }
                if(j == a-1) ans[i] = -1;
            }
        }
        return ans;
    }
}