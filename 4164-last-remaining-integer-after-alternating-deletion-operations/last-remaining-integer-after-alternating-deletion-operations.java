class Solution {
    public long lastInteger(long n) {
        long a = 1, d = 1, step = 0;
        while(n > 0) {
            long len = 1 + ((n-a)/d);
            if(len == 1) break;
            if(step % 2 == 1 && len % 2 == 0) a += d;
            d *= 2;
            step++;
        }
        return a;
    }
}