class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] prev = new int[m];
        int[] curr = new int[m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                curr[j] = nums1[i] * nums2[j];
                if( i > 0 && j > 0) curr[j] = Math.max(curr[j], nums1[i]*nums2[j] + Math.max(0, prev[j-1]));
                if( i > 0) curr[j] = Math.max(curr[j], prev[j]);
                if( j > 0) curr[j] = Math.max(curr[j],curr[j-1]);
            }
            prev = curr;
            curr = new int[m];
        }
        return prev[m-1];
    }
}