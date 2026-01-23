class Solution {
    private int cntSplits(int[] a, int mxSum) {
        int parti = 1;
        long subArraySum = 0;
        for(int i = 0; i < a.length; i++) {
            if(subArraySum + a[i] <= mxSum) subArraySum += a[i];
            else {
                parti++;
                subArraySum = a[i];
            }
        }
        return parti;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0, ans = 0;
        for(int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(cntSplits(nums, mid) > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}