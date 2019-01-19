public class Solution {
    
    public void solve(ArrayList<ArrayList<Character>> a) {
        boolean[][] visited = new boolean[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size(); i++) {
            if (!visited[i][0] && a.get(i).get(0) == 'O')
                dfs(a, i, 0, visited);
            if (!visited[i][a.get(0).size() - 1] && a.get(i).get(a.get(0).size() - 1) == 'O')
                dfs(a, i, a.get(0).size() - 1, visited);
        }
        for (int j = 0; j < a.get(0).size(); j++) {
            if (!visited[0][j] && a.get(0).get(j) == 'O')
                dfs(a, 0, j, visited);
            if (!visited[a.size() - 1][j] && a.get(a.size() - 1).get(j) == 'O')
                dfs(a, a.size() - 1, j, visited);
        }
        
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 'C') {
                    a.get(i).set(j, 'O');
                }else if (a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                }
            }
        }
    }
    
    public void dfs(ArrayList<ArrayList<Character>> a, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        a.get(i).set(j, 'C');
        if (i - 1 >= 0 && !visited[i - 1][j] && a.get(i - 1).get(j) == 'O') {
            dfs(a, i - 1, j, visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && a.get(i).get(j - 1) == 'O') {
            dfs(a, i, j - 1, visited);
        }
        if (i + 1 < a.size() && !visited[i + 1][j] && a.get(i + 1).get(j) == 'O') {
            dfs(a, i + 1, j, visited);
        }
        if (j + 1 < a.get(0).size() && !visited[i][j + 1] && a.get(i).get(j + 1) == 'O') {
            dfs(a, i, j + 1, visited);
        }
    }
}
