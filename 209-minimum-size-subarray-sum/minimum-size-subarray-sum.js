/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {

    let n = nums.length, sum = 0, low = 0, minLen = Infinity;
    for(let high = low; high < n; high++) {
        sum += nums[high];

        while(sum >= target) {
            minLen = Math.min(minLen, high - low + 1);
            sum -= nums[low];
            low++;
        }
    }
    return minLen === Infinity ? 0 : minLen;
    
};