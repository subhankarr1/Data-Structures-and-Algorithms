class Solution {
    public int numOfWays(int n) {
        
        if(n == 0) return 0;
        int MOD = (int)(1_000_000_007);
        long two = 6, three = 6;
        n--;
        while(n > 0)
        {
            long nextTwo = (3 * two + 2 * three) % MOD;
            three = (2 * three + 2 * two) % MOD;
            two = nextTwo;
            n--;
        }
        return (int)(two + three) % MOD;
    }
}