class Solution {
    public int sumFourDivisors(int[] nums) {

        int tot = 0;
        for (int n : nums) {
            int cnt = 0, sum = 0;
            for (int i = 1; i * i <= n; ++i) {
                if (n % i == 0) {
                    int otherD = n / i;
                    sum += i;
                    cnt++;

                    if (i != otherD) {
                        sum += otherD;
                        cnt++;
                    }
                    if (cnt > 4)
                        break;
                }
            }
            if (cnt == 4)
                tot += sum;
        }
        return tot;
    }
}