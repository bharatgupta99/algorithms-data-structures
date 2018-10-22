import java.util.LinkedList;
import java.util.Iterator;

public class DFTraversal {
	
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

	//depth first travesral
	private static void DFSTraversal(Graph graph, int start, boolean[] visited) {
		System.out.println(start);
		visited[start] = true;

		Iterator it = graph.g[start].listIterator();
		while(it.hasNext()) {
			int val = (Integer)it.next();
			if(!visited[val]) {
				DFSTraversal(graph, val, visited);
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
		DFSTraversal(graph, 2, visited);

	}
	
}