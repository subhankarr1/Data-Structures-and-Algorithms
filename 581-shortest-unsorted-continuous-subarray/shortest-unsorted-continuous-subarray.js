/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function(nums) {
    let n = nums.length, l = n, r = -1;
    let sorted = [...nums].sort((a,b) => a-b);

    for(let i = 0; i < n; i++) {
      if(nums[i] !== sorted[i]){
        l = Math.min(l, i);
        r = Math.max(r, i);
      }
    }
    if(l > r) return 0;
    return r-l+1;
};