/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function (nums) {
    let n = nums.length, maxs = nums[0], mins = nums[n - 1], l = -1, r = -1;

    for (let j = n - 2; j >= 0; j--) {
        if (mins < nums[j]) {
            l = j;
        }
        else {
            mins = nums[j];
        }
    }

    for (let i = 1; i < n; i++) {
        if (maxs > nums[i]) {
            r = i;
        }
        else {
            maxs = nums[i];
        }
    }
    if (l == -1) return 0;
    return r - l + 1;


};