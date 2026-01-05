class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int i = 0; i < n-2; i++)
        {
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2]) return nums[i];
        }
        return nums[n-1];
    }
}