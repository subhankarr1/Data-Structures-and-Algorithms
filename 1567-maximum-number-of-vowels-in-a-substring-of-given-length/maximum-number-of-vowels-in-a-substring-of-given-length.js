/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function(s, k) {
    let n = s.length, low = 0, vo = 0, res = -Infinity;
    let f = new Set(["a", "e", "i", "o", "u"]);

    for(let high = 0; high < n; high++) {
        if(f.has(s[high])) vo++;
        let currLen = high - low + 1;

        while(currLen > k) {
            if(f.has(s[low])) vo--;
            low++;
            currLen = high - low + 1;
        }
        currLen = high - low + 1;
        res = Math.max(res, vo);
    }
    return res;
};