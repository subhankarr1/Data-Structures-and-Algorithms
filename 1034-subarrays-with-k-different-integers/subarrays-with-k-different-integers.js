/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

function atMostK(nums, k) {
 let n = nums.length, low = 0, res = 0, len = 0;
    let f = new Map();

    for(let high = 0; high < n; high++) {
        f.set(nums[high], (f.get(nums[high]) || 0) + 1);

        while(f.size > k) {
            f.set(nums[low], f.get(nums[low]) - 1);
            if(f.get(nums[low]) === 0) f.delete(nums[low]);
            low++;
        }
        res +=  high - low + 1;
    }
    return res;
}

var subarraysWithKDistinct = function(nums, k) {
    return atMostK(nums, k) - atMostK(nums, k-1);
};