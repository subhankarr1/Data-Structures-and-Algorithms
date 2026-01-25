class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0;
        ArrayList<Integer> merge = new ArrayList<>();
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) merge.add(nums1[i++]);
            else merge.add(nums2[j++]);
        }
        while(i < n1) merge.add(nums1[i++]);
        while(j < n2) merge.add(nums2[j++]);
        int n = merge.size();
        if(n % 2 == 1) return merge.get(n / 2);

        return (merge.get(n / 2 - 1) + merge.get(n / 2)) / 2.0;
    }
}