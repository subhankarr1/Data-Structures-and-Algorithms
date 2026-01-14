class event {
    double y;
    int type, xStart, xEnd;
    event(double y, int type, int xStart, int xEnd) {
        this.y = y;
        this.type = type;
        this.xStart = xStart;
        this.xEnd = xEnd;
    }
}

class Solution {
    private void updateTree(int node, int start, int end, int left, int right, int value, int[] x, int[] coverCnt, double[] coveredLen) {
        if(right <= start || end <= left) return;
        if(left <= start && end <= right) coverCnt[node] += value;
        else {
            int mid = (start + end) / 2;
            updateTree(node * 2, start, mid, left, right, value, x, coverCnt, coveredLen);
            updateTree(node * 2 + 1, mid, end, left, right, value, x, coverCnt, coveredLen);
        }
        if(coverCnt[node] > 0) coveredLen[node] = x[end] - x[start];
        else {
            if(end - start == 1) coveredLen[node] = 0;
            else {
                coveredLen[node] = coveredLen[node * 2] + coveredLen[node * 2 + 1];
            }
        }
    }

    public double separateSquares(int[][] squares) {
        List<event> events = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int [] s : squares) {
            int x = s[0], y = s[1], size = s[2];
            events.add(new event(y, 1, x, x + size));
            events.add(new event(y + size, -1, x, x + size));
            set.add(x);
            set.add(x + size);
        }
        int n = set.size(), p = 0;
        int[] x = new int[n];
        for(int ii : set) {
            x[p] = ii;
            p++;
        }
        Arrays.sort(x);
        events.sort(Comparator.comparingDouble(e -> e.y));
        
        int[] coverCnt = new int[4 * n];
        double[] coveredLen = new double[4 * n];
        double totalArea = 0;
        double prevY = events.get(0).y;
        List<double[]> parts = new ArrayList<>();
        int i = 0;

        while( i < events.size()) {
            double currY = events.get(i).y;
            if(currY > prevY) {
                double height = currY - prevY;
                double width = coveredLen[1];
                totalArea += width * height;
                parts.add(new double[]{prevY, currY, width});
                prevY = currY;
            }
            while( i < events.size() && events.get(i).y == currY) {
                event e = events.get(i);
                int left = Arrays.binarySearch(x, e.xStart);
                int right = Arrays.binarySearch(x, e.xEnd);
                updateTree(1, 0, n, left, right, e.type, x, coverCnt, coveredLen);
                i++;
            }
        }
        double half = totalArea / 2;
        double sum = 0;
        for(double[] part : parts) {
            double y1 = part[0], y2 = part[1], width = part[2];
            double area = width * (y2 - y1);
            if(sum + area >= half) return y1 + (half - sum) / width; 
            sum += area;
        }
        return prevY;
    }
}
