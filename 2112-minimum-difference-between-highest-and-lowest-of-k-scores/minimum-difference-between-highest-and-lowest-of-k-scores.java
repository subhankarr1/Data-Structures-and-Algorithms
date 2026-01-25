class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        Arrays.sort(nums);
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++) mini = Math.min(mini, nums[i+k-1] - nums[i]);
        return mini;
    }
}