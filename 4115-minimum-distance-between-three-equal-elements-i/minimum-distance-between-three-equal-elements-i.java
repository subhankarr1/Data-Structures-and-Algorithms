class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int miniD = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
            {
                for(int j = i+1; j < n; j++)
                    {
                        for(int k = j+1; k < n; k++)
                            {
                                if(nums[i] == nums[j] && nums[j] == nums[k]) {
                                    int d = Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i);
                                    miniD = Math.min(miniD, d);
                                }
                            }
                    }
            }
        return miniD == Integer.MAX_VALUE ? -1 : miniD;
    }
}