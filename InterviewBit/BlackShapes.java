public class Solution {
    public int black(ArrayList<String> A) {
        int res = 0;
        boolean[][] visited = new boolean[A.size()][A.get(0).length()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).length(); j++) {
                if (!visited[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(A, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(ArrayList<String> A, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && A.get(i - 1).charAt(j) == 'X') {
            dfs(A, i - 1, j, visited);
        }
        if (i + 1 < A.size() && !visited[i + 1][j] && A.get(i + 1).charAt(j) == 'X') {
            dfs(A, i + 1, j, visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && A.get(i).charAt(j - 1) == 'X') {
            dfs(A, i, j - 1, visited);
        }
        if (j + 1 < A.get(0).length() && !visited[i][j + 1] && A.get(i).charAt(j + 1) == 'X') {
            dfs(A, i, j + 1, visited);
        }
        return;
    }
}
