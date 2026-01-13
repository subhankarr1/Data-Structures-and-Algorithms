class Solution {
    private double areaBelow(double mid, int[][] squares) {
        double area = 0;
        for(int[] s : squares) {
            double y = s[1], len = s[2];
            if(mid >= y+len) area += len * len;
            else if(mid > y && mid < y+len) area += len * (mid-y);
        }
        return area;
    }

    public double separateSquares(int[][] squares) {
        double mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE, totalArea = 0;
        for(int[] s : squares) {
            double len = s[2];
            totalArea += len * len;
            mini = Math.min(mini, s[1]);
            maxi = Math.max(maxi, s[1]+len);
        }
        double target = totalArea/2, low = mini, high = maxi;
        while(low < high) {
            if(high - low < Math.pow(10, -5)) break;
            double mid = (low + high) / 2;
            if(areaBelow(mid, squares) < target) low = mid;
            else high = mid;
        }
        return high;
    }
}