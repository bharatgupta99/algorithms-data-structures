import java.util.LinkedList;

public class Solution {

    private class Graph {
        LinkedList<Integer>[] g;
        int v;
        
        Graph (int len) {
            v = len;
            g = new LinkedList[len];    
            for (int i = 0; i < len; i++) {
                g[i] = new LinkedList<>();
            }
        }
        
        public void add(int a, int b) {
            g[a].add(b);
        }
        
        private boolean detectCycle(int vert, boolean[] visited, ArrayList<Integer> stck) {
            visited[vert] = true;
            stck.add(vert);
            
            Iterator<Integer> itr = g[vert].iterator();
            while (itr.hasNext()) {
                int t = itr.next();
                if (!visited[t]) {
                    detectCycle(t, visited, stck);
                } else if (stck.contains(t)) {
                    return true;
                }
            }
            stck.remove(stck.size() - 1);
            return false;
        }
        
        public boolean hasCycle() {
            
            boolean[] visited = new boolean[v];
            ArrayList<Integer> stck = new ArrayList<>();
            
            for (int i = 0; i < v; i++) {
                if (detectCycle(i, visited, stck)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Graph g = new Graph(A);
        for (int i = 0; i < B.size(); i++) {
            g.add(B.get(i) - 1, C.get(i) - 1);
        }
        
        if (g.hasCycle()) {
            return 0;
        }
        
        return 1;
    }
}
