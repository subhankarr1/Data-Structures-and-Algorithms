/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let n = height.length, l = 0, r = n - 1, maxArea = 0;

    while (l < r) {
        let currWidth = r - l;
        let currHeight = Math.min(height[l], height[r]);
        maxArea = Math.max(maxArea, currWidth * currHeight);

        if (height[l] < height[r]) {
            l++;
        }
        else r--;
    }
    return maxArea;
};