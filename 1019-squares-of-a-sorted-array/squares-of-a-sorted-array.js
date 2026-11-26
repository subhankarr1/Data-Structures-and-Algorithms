/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {

    let n = nums.length, l = 0, r = n - 1;
    let res = new Array(n);

    for (let i = n - 1; i >= 0; i--) {

        let ls = nums[l] * nums[l];
        let rs = nums[r] * nums[r];

        if (ls > rs) {
            res[i] = ls;
            l++;
        }
        else {
            res[i] = rs;
            r--;
        }
    }
    return res;
};