class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int id = -1;
    }
    private void insert(TrieNode root, String s, int id) {
        TrieNode node = root;
        for(char c : s.toCharArray()) {
            int ind = c - 'a';
            if(node.next[ind] == null) {
                node.next[ind] = new TrieNode();
            }
            node = node.next[ind];
        }
        node.id = id;
    }
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Integer> strToId = new HashMap<>();
        TrieNode root = new TrieNode();
        int idCnt = 0;

        for(String s : original) {
            if(!strToId.containsKey(s)) {
                strToId.put(s, idCnt);
                insert(root, s, idCnt);
                idCnt++;
            }
        }
        for(String s : changed) {
            if(!strToId.containsKey(s)) {
                strToId.put(s, idCnt);
                insert(root, s, idCnt);
                idCnt++;
            }
        }
        long[][] d = new long[idCnt][idCnt];
        long INF = Long.MAX_VALUE;
        for(long[] i : d) Arrays.fill(i, INF);
        for(int i = 0; i < idCnt; i++) {
            d[i][i] = 0;
        }
        for(int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            d[u][v] = Math.min(d[u][v], cost[i]);
        }
        for(int k = 0; k < idCnt; k++) {
            for(int i = 0; i < idCnt; i++) {
                if(d[i][k] == INF) continue;
                for(int j = 0; j < idCnt; j++) {
                    if(d[k][j] == INF) continue;
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        long[] dp = new long[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        for(int i = 0; i < n; i++) {
            if(dp[i] == INF) continue;
            if(s[i] == t[i]) dp[i+1] = Math.min(dp[i+1], dp[i]);
            Map<Integer, Integer> lenToTargetId = new HashMap<>();
        
            TrieNode tNode = root;
            for(int j = i; j < n; j++) {
                int ind = t[j] - 'a';
                if(tNode.next[ind] == null) break;
                tNode = tNode.next[ind];
                if(tNode.id != -1) {
                    lenToTargetId.put(j-i+1, tNode.id);
                }
            }
            TrieNode sNode = root;
            for(int j = i; j < n; j++) {
                int ind = s[j] - 'a';
                if(sNode.next[ind] == null) break;
                sNode = sNode.next[ind];
                if(sNode.id != -1) {
                    int len = j-i+1;
                    if(lenToTargetId.containsKey(len)) {
                        int sId = sNode.id;
                        int tId = lenToTargetId.get(len);
                        if(d[sId][tId] != INF) {
                            dp[i+len] = Math.min(dp[i+len], dp[i] + d[sId][tId]);
                        }
                    }
                }
            }
        } 
        return dp[n] == INF ? -1 : dp[n];
    }
}