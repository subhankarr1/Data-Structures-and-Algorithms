/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */

function check(have, goal) {
    for (let i = 0; i < 256; i++) {
        if (have[i] < goal[i]) return false;
    }
    return true;
}

var minWindow = function (s, t) {
    let n = s.length, m = t.length;
    if (n < m) return "";
    let have = new Array(256).fill(0);
    let goal = new Array(256).fill(0);
    let low = 0, res = Infinity, st = -1;

    for (let i = 0; i < m; i++) goal[t.charCodeAt(i)]++;

    for (let high = 0; high < n; high++) {
        have[s.charCodeAt(high)]++;

        while (check(have, goal)) {
            let len = high - low + 1;
            if (res > len) {
                res = len;
                st = low;
            }
            have[s.charCodeAt(low)]--;
            low++;
        }
    }
    if (res === Infinity) return "";
    return s.substring(st, st + res);

};