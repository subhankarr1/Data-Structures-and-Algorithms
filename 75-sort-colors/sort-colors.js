/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */


var sortColors = function(nums) {
    
    function swap(nums, i, j) {
        let temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    let n = nums.length, low = 0, mid = 0, high = n-1;

    while(mid <= high) {
        if(nums[mid] == 0) {
            swap(nums, low, mid);
            low++;
            mid++;
        }
        else if(nums[mid] == 1) mid++;
        else {
            swap(nums, mid, high);
            high--;
        }
    }
};