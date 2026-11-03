/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
    let n = nums.length;
    let red = 0, white = 0, blue = 0;
    for (let i = 0; i < n; i++) {
        if (nums[i] == 0) red++;
        if (nums[i] == 1) white++;
        if (nums[i] == 2) blue++;
    }
    let k = 0;
    while (red > 0) {
        nums[k++] = 0;
        red--;
    }

    while (white > 0) {
        nums[k++] = 1;
        white--;
    }

    while (blue > 0) {
        nums[k++] = 2;
        blue--;
    }
};