/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countSubarrays = function(nums, k) {
    let n = nums.length, low = 0, res = 0, cnt = 0, maxEle = 0;
    for(let x of nums) maxEle = Math.max(maxEle, x); 

    for(let high = 0; high < n; high++) {
        if(nums[high] === maxEle) cnt++;   // cnt = 3  cnt > k(2)
        
        while(cnt >= k) {
            if(nums[low] === maxEle) cnt--;
            low++; 
        }
        res += low;
    }
    return res;
};