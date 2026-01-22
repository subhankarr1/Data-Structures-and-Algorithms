class Solution {
    private boolean check(List<Integer> lst) {
        for(int i = 0; i < lst.size() - 1; i++) {
            if(lst.get(i) > lst.get(i+1)) return false;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int num : nums) lst.add(num);   

        if(check(lst)) return 0;
        int cnt = 0;
        while(!check(lst)) {
            int sum = Integer.MAX_VALUE;
            int ind = -1;
            for(int i = 0; i < lst.size() - 1; i++) {
                int currSum = lst.get(i) + lst.get(i+1);
                if(currSum < sum) {
                    sum = currSum;
                    ind = i;
                }
            }
            int element = lst.get(ind) + lst.get(ind+1);
            lst.remove(ind+1);
            lst.set(ind, element);
            cnt++; 
        }
        return cnt;
    }
}