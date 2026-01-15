class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        int i = 0, j = 0, cnt1 = 1, cnt2 = 1, maxH = 1, maxV = 1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        while (i < hBars.length - 1 || j < vBars.length - 1) {
            if (i < hBars.length - 1) {
                if (hBars[i + 1] - hBars[i] == 1) {
                    cnt1++;
                } else {
                    maxH = Math.max(maxH, cnt1);
                    cnt1 = 1;
                }
                i++;
            }
            if (j < vBars.length - 1) {
                if (vBars[j + 1] - vBars[j] == 1) {
                    cnt2++;
                } else {
                    maxV = Math.max(maxV, cnt2);
                    cnt2 = 1;
                }
                j++;
            }
        }
        maxH = Math.max(maxH, cnt1);
        maxV = Math.max(maxV, cnt2);
        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
}