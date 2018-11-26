import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class BFTraversal {

	//graph
	private static class Graph {
		private LinkedList<Integer>[] g; 
		private int V;
		private Graph(int V) {
			this.V = V;
			g = new LinkedList[V];
			for(int i = 0; i < V; i++) {
				g[i] = new LinkedList<Integer>();
			}
		}
	}

	//directed graph insert
	private static void add(Graph graph, int a, int b) {
		graph.g[a].add(b);
	}

	private static void BFSTraversal(Graph graph, int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();

		visited[start] = true;
		q.add(start);

		while(!q.isEmpty()) {
			int val = q.poll();
			System.out.println(val);
			visited[val] = true;

			Iterator it = graph.g[val].listIterator();
			while(it.hasNext()) {
				int v = (Integer)it.next();
				if(!visited[v]) {
					q.add(v);
				}
			}
		}
	}
	
	
	public static void main(String args[]) {

		// no. of verteces
		int V = 4;

		//insert elements
		Graph graph = new Graph(V);
		add(graph, 0, 1);
		add(graph, 0, 2);
		add(graph, 1, 2);
		add(graph, 2, 0);
		add(graph, 2, 3);
		add(graph, 3, 3);


		//dept first traversal
		boolean[] visited = new boolean[V];
		BFSTraversal(graph, 2, visited);

	}
}