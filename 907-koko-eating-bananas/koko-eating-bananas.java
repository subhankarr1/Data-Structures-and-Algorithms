class Solution {
    private long calculateHours(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) hours += (pile + k - 1) / k;
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) high = Math.max(high, pile);
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (calculateHours(piles, mid) <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}