/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function (people, limit) {
    let n = people.length, l = 0, r = n - 1, boats = 0;
    people.sort((a, b) => a - b);

    while (l <= r) {
        if (people[l] + people[r] <= limit) {
            boats++;
            l++;
            r--;
        }
        else {
            r--;
            boats++;
        }
    }
    return boats;
};