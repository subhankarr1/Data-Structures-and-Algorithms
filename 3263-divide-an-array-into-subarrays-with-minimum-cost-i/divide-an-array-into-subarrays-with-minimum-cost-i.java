class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        int mini1 = Integer.MAX_VALUE, mini2 = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if(curr < mini1) {
                mini2 = mini1;
                mini1 = curr;
            }
            else if(curr < mini2){
                mini2 = curr;
            }
        }
        cost += mini1;
        cost += mini2;
        return cost;
    }
}