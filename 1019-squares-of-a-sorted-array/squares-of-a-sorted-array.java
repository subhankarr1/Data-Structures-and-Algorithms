class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num < 0)
                neg.add(num);
            else
                pos.add(num);
        }
        if (neg.size() == 0) {
            for (int i = 0; i < pos.size(); i++)
                pos.set(i, pos.get(i) * pos.get(i));
            return pos.stream().mapToInt(Integer::intValue).toArray();

        }
        if (pos.size() == 0) {
            for (int i = 0; i < neg.size(); i++)
                neg.set(i, neg.get(i) * neg.get(i));
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();

        }
        int i = 0, j = 0;

        for (i = 0; i < neg.size(); i++)
            neg.set(i, neg.get(i) * neg.get(i));
        Collections.reverse(neg);

        for(i = 0; i < pos.size(); i++)
            pos.set(i, pos.get(i) * pos.get(i));

        i = 0;
        j = 0;
        int id = 0;
        int[] res = new int[neg.size() + pos.size()]; 

        while(i < neg.size() && j < pos.size()) 
        {
            if(neg.get(i) < pos.get(j)) 
            {
                res[id++] = neg.get(i++);
            }
            else 
            {
                res[id++] = pos.get(j++);
            }
        } 

        while(j < pos.size()) 
        {
            res[id++] = pos.get(j++);
        }
        while(i < neg.size())
        {
            res[id++] = neg.get(i++);
        }
        return res;

    }
}