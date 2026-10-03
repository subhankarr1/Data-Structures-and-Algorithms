/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
    let n = nums.length;
    let res = [];
    nums.sort((a, b) => a - b);

    for (let i = 0; i < n - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        let left = i + 1, right = n - 1;
        let sum = -1 * nums[i];

        while (left < right) {
            let s = nums[i] + nums[left] + nums[right];
            if (s === 0) {
                res.push([nums[i], nums[left], nums[right]]);
                left++;
                right--;
                while (left < n && nums[left] === nums[left - 1]) {
                    left++;
                }
                while (right >= 0 && nums[right] === nums[right + 1]) {
                    right--;
                }
            }
            else if (s < 0) left++;
            else right--;
        }
    }
    return res;
}
