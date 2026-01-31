class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        int low = 0, high = letters.length - 1;
        while(letters[high] <= target) return ans;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            char ch = letters[mid];
            if(ch > target) {
                ans = ch;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}