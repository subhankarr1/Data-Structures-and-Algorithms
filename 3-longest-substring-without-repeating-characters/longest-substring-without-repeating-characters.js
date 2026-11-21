/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {

    let n = s.length, low = 0, res = 0;
    let f = new Map();

    for (let high = 0; high < n; high++) {
        f.set(s[high], (f.get(s[high]) || 0) + 1);
        let currlen = high - low + 1;

        while (f.size < currlen) {
            f.set(s[low], f.get(s[low]) - 1);
            if (f.get(s[low]) === 0) {
                f.delete(s[low]);
            }
            low++;
            currlen = high - low + 1;
        }
        curlen = high - low + 1;
        res = Math.max(res, currlen);
    }
    return res;
};