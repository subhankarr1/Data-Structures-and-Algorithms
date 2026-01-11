class Solution {

    private int largestRec(int[] height) {
        int n = height.length;
        int pse, area, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && height[st.peek()] >= height[i]) {
                int ind = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                area = height[ind] * (i - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int ind = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            area = height[ind] * (n - pse - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length, maxArea = 0;
        int[] psum = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1')  psum[j]++;
                else psum[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRec(psum));
        }
        return maxArea;
    }
}