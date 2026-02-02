class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
         int n = nums.length;
        TreeSet<Integer> sel = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });
          TreeSet<Integer> rem = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });
        k = k-1;
        long currSum = 0, ans = Long.MAX_VALUE, last = Math.min(dist+1, n-1);
        for(int i = 1; i <= last; i++) {
            currSum += nums[i];
            sel.add(i);
        }
        while(sel.size() > k) {
            int ind = sel.pollLast();
            currSum -= nums[ind];
            rem.add(ind);
        } 
        ans = currSum;
        for(int r = dist+2, l = 1; r < n; r++, l++) {
            rem.add(r);
            if(sel.contains(l)) {
                sel.remove(l);
                currSum -= nums[l];
                int small = rem.pollFirst();
                sel.add(small);
                currSum += nums[small];
            }
            else {
                rem.remove(l);
                if(!sel.isEmpty() && !rem.isEmpty() && nums[sel.last()] > nums[rem.first()]) {
                    int large = sel.pollLast();
                    int small = rem.pollFirst();
                    currSum -= nums[large];
                    rem.add(large);
                    sel.add(small);
                    currSum += nums[small];
                }
            }
            ans = Math.min(ans, currSum);
        }
        return nums[0] + ans;
    }
}