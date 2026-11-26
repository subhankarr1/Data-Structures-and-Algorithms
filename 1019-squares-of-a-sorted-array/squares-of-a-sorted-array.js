/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function (nums) {

    let num = nums.length;
    let neg = [];
    let pos = [];

    for(let i = 0; i < num; i++) {
        if(nums[i] >= 0) pos.push(nums[i]);
        else neg.push(nums[i]);
    }

    if(neg.length === 0) {
        for(let i = 0; i < pos.length; i++){
            pos[i] = pos[i] * pos[i];
        }
        return pos;
    }
    
    if(pos.length === 0) {
        for(let i = 0; i < neg.length; i++){
            neg[i] = neg[i] * neg[i];
        }
        neg.reverse();
        return neg;
    }

    for(let i = 0; i < neg.length; i++) neg[i] = neg[i] * neg[i];
    neg.reverse();
    for(let i = 0; i < pos.length; i++) pos[i] = pos[i] * pos[i];

    let i = 0, j = 0, idx = 0, n = pos.length, m = neg.length;
    let res = new Array(n+m);

    while(i < m && j < n) {
        if(neg[i] < pos[j]) {
            res[idx++] = neg[i++];
        }
        else res[idx++] = pos[j++];
    }

    while(j < n) {
        res[idx++] = pos[j++];
    }
    while(i < m) {
        res[idx++] = neg[i++];
    }

    return res;
};

// let n = nums.length, l = 0, r = n - 1;
//     let res = new Array(n);

//     for (let i = n - 1; i >= 0; i--) {

//         let ls = nums[l] * nums[l];
//         let rs = nums[r] * nums[r];

//         if (ls > rs) {
//             res[i] = ls;
//             l++;
//         }
//         else {
//             res[i] = rs;
//             r--;
//         }
//     }
//     return res;