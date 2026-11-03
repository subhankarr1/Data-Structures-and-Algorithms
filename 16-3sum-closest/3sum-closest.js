/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
    let n = nums.length;
    nums.sort((a, b) => a - b);
    let ans = nums[0] + nums[1] + nums[2];

    for (let i = 0; i < n - 2; i++) {
        let l = i + 1, r = n - 1;

        while (l < r) {
            let sum = nums[i] + nums[l] + nums[r];

            if (sum == target) return sum;
            if (sum < target) {
                l++;
            }
            else {
                r--;
            }
            if (Math.abs(target - sum) < Math.abs(target - ans))
            ans = sum;
        }
    }
    return ans;
};