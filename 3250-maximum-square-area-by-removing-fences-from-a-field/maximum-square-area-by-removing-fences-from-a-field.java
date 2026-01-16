class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        
        if(m == n) return (m-1) * (n-1);
        Set<Integer> set = new HashSet<>();
        int mxSide = Integer.MIN_VALUE;
        long MOD = 1_000_000_007;
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;
        for(int i = 0; i < hFences.length; i++) h[i+1] = hFences[i];
        for(int i = 0; i < vFences.length; i++) v[i+1] = vFences[i];
        Arrays.sort(h);
        Arrays.sort(v);

        for(int i = 0; i < h.length; i++) {
            for(int j = i+1; j < h.length; j++) {
                set.add(h[j] - h[i]);
            }
        }
        for(int i = 0; i < v.length; i++) {
            for(int j = i+1; j < v.length; j++) {
                if(set.contains(v[j] - v[i])) {
                    mxSide = Math.max(mxSide, v[j] - v[i]);
                }
            }
        }
        if(mxSide == Integer.MIN_VALUE) return -1;
        return (int)((1L * mxSide * mxSide) % MOD);
    }
}