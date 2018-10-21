import java.util.LinkedList;

//undirected graph
class AdjacencyList {
	
	private static class Graph {
		private int V;
		private LinkedList<Integer>[] g;

		private Graph(int V) {
			this.V = V;
			g = new LinkedList[V];
			for(int i = 0; i < V; i++) {
				g[i] = new LinkedList<Integer>();
			}
		}
	}

	public static void add(Graph graph, int a, int b) {
		graph.g[a].add(b);
		graph.g[b].add(a);
	}

	public static void print(Graph graph) {
		for(int i = 0; i < 4; i++) {
			for(Integer val : graph.g[i]) {
				System.out.print(val);
			}
			System.out.print("\n");
		}
	}

	public static void main(String args[]) {

		//5 = no. of verteces
		Graph graph = new Graph(5);
		
		add(graph, 0, 1);
		add(graph, 0, 3);
		add(graph, 1, 2);
		add(graph, 3, 2);

		print(graph);
	}

	
}

/*
1. Space Complexity is very low
2. Time Complexity(Access Time) is more than Adjacency Matrix but difference is less
*/