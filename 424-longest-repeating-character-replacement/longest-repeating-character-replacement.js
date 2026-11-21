/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function (s, k) {

    let n = s.length, low = 0, res = 0;
    let f = new Array(256).fill(0);

    for (let high = 0; high < n; high++) {
        f[s.charCodeAt(high)]++;
        let currlen = high - low + 1;
        let mxCnt = Math.max(...f);
        let diff = currlen - mxCnt;

        while (diff > k) {
            f[s.charCodeAt(low)]--;
            low++;

            currlen = high - low + 1;
            mxCnt = Math.max(...f);
            diff = currlen - mxCnt;
        }
        currlen = high - low + 1;
        res = Math.max(res, currlen);
    }
    return res;
};