class Pair implements Comparable<Pair> {
    int ind;
    long val, sum;
    Pair left, right;

    Pair(int ind, long val) {
        this.ind = ind;
        this.val = val;
    }
    public int compareTo(Pair other) {
        if(this.right == null || other.right == null) {
            return this.right == null ? 1 : -1;
        }
        long diff = this.sum - other.sum;
        return diff != 0 ? (diff < 0 ? -1 : 1) : (this.ind - other.ind);
    }
}

class Solution {
    public int minimumPairRemoval(int[] nums) {
        TreeSet<Pair> set = new TreeSet<>();
        int misMatch = 0;
        Pair prev = null;
        for(int i = 0; i < nums.length; i++) {
            Pair curr = new Pair(i, nums[i]);
            if(prev == null) {
                prev = curr;
            }
            else {
                if(prev.val > curr.val) misMatch++;
                prev.right = curr;
                curr.left = prev;
                prev.sum = prev.val + curr.val;
                set.add(prev);
                prev = curr;
            }
        }
        set.add(prev);
        int cnt = 0;
        while(misMatch > 0) {
            Pair best = set.pollFirst();
            if(best.val > best.right.val) misMatch--;
            best.sum = best.val + best.right.sum;
            best.val = best.val + best.right.val;
            Pair del = best.right;
            best.right = del.right;

            if(del.right != null) {
                if(del.val > del.right.val) misMatch--;
                del.right.left = best;
                if(best.val > best.right.val) misMatch++;
            }
            set.remove(del);
            set.add(best);
            Pair left = best.left;
            if(left != null) {
                set.remove(left);
                if(left.val > left.sum - left.val) misMatch--;
                if(left.val > best.val) misMatch++;
                left.sum = left.val + best.val;
                left.right = best;
                set.add(left);
            }
            cnt++;
        }
        return cnt;
    }
}