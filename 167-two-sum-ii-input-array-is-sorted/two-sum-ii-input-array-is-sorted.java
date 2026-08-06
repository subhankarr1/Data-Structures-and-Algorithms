class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int i = 0, j = n-1;
        while(i < j) 
        {
            int sum = numbers[i] + numbers[j];
            if(sum == target) 
            return new int[]{i+1, j+1};
            else if(sum < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }
}