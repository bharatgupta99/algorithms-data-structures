public class Solution {
    
    private class Pair {
        int x, y, serial;
        private Pair(int x, int y, int serial) {
            this.x = x;
            this.y = y;
            this.serial = serial;
        }
    }
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A + 1][B + 1];
        int[][] dir = {{2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
        Pair ini = new Pair(C, D, 0); //Source
        
        Queue<Pair> q = new LinkedList<>();
        q.add(ini);
        visited[ini.x][ini.y] = true;
        
        while (q.size() != 0) {
            Pair temp = q.poll();
            visited[temp.x][temp.y] = true;
            
            for (int i = 0; i < 8; i++) {
                if (isValid(temp.x + dir[i][0], temp.y + dir[i][1], A + 1, B + 1) && !visited[temp.x + dir[i][0]][temp.y + dir[i][1]]) {
                    q.add(new Pair(temp.x + dir[i][0], temp.y + dir[i][1], temp.serial + 1));
                }
            }
            
            if (temp.x == E && temp.y == F) {
                return temp.serial;
            }
        }
        return -1;
        
    }
    
    private boolean isValid(int x, int y, int bx, int by) {
        if (x > 0 && x < bx && y > 0 && y < by) {
            return true;
        }
        
        return false;
    }
}
