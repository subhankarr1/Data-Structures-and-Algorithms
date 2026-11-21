/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestOnes = function(nums, k) {
    let n = nums.length, low = 0, zeros = 0, res = -Infinity;


    for(let high = 0; high < n; high++) {
        if(nums[high] === 0) zeros++;
        let currLen = high - low + 1;
        
        while(zeros > k) {
           if(nums[low] === 0) zeros--;
            low++;
            currLen = high - low + 1;
        }
        currLen = high - low + 1;
        res = Math.max(res, currLen);
    }
    return res;
};