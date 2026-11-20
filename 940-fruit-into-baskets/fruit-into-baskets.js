/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function (fruits) {
    let n = fruits.length, low = 0, high = 0, res = 0;
    let freq = new Map();

    for (let high = 0; high < n; high++) {
        freq.set(fruits[high], (freq.get(fruits[high]) || 0) + 1);
        while (freq.size > 2) {
            freq.set(fruits[low], freq.get(fruits[low]) - 1);
            if(freq.get(fruits[low]) === 0) freq.delete(fruits[low]);
            low++;
        }
        let len = high - low + 1;
        res = Math.max(res, len)
    }
    return res;
};