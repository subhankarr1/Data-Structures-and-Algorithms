/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    
    let n = s.length, m = p.length, low = 0, res = [];
    let patternFreq = new Array(26).fill(0);
    let windowFreq = new Array(26).fill(0);
    if(n < m) return res;
    for(let x of p) patternFreq[x.charCodeAt(0) - 97]++;

    for(let high = 0; high < n; high++) {
        windowFreq[s.charCodeAt(high) - 97]++;

        let currLen = high - low + 1;

        while(currLen > m) {
            windowFreq[s.charCodeAt(low) - 97]--;
            low++;
            currLen = high - low + 1;
        }
        if(currLen === m) {
            if(patternFreq.every((val, i) => val === windowFreq[i])) res.push(low);
        }
    }
    return res;
};