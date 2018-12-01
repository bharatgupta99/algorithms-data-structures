import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bipardite {
	
	private UndirectedGraph g;
	private static final boolean WHITE = true;
	//private static final boolean BLACK = false;
	private boolean[] visited;
	private boolean[] color;
	private boolean isBipartite;
	
	public Bipardite(UndirectedGraph g) {
		this.g = g;
		visited = new boolean[g.getVerteces()];
		color = new boolean[g.getVerteces()];
		for(int i = 0; i < g.getVerteces(); i++) {
			visited[i] = false;
		}
		isBipartite = true;
		bfs();
	}
	
	private void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		color[0] = WHITE;
		visited[0] = true;
		while(!queue.isEmpty()) {
			int top = queue.poll();
			Iterator<Integer> itr = g.getBag(top).iterator();
			while(itr.hasNext()) {
				int temp = itr.next();
				if(!visited[temp]) {
					queue.add(temp);
					visited[temp] = true;
					System.out.println(temp);
					color[temp] = !color[top];
				}else {
					if(color[temp] == color[top]) {
						isBipartite = false;
						break;
					}
				}
			}
			if(isBipartite == false) {
				break;
			}
			
		}
	}
	
	public boolean isBipartite() {
		return isBipartite;
	}
	
}
