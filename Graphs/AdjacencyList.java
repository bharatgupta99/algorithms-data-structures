import java.util.LinkedList;

//undirected graph
class AdjacencyList {
	public static void main(String args[]) {
		LinkedList<Integer>[] graph = new LinkedList[4];
		for(int i = 0; i < 4; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		add(graph, 0, 1);
		add(graph, 0, 3);
		add(graph, 1, 2);
		add(graph, 3, 2);

		print(graph);
	}

	public static void add(LinkedList<Integer>[] graph, int a, int b) {
		graph[a].add(b);
		graph[b].add(a);
	}

	public static void print(LinkedList<Integer>[] graph) {
		for(int i = 0; i < 4; i++) {
			for(Integer val : graph[i]) {
				System.out.print(val);
			}
			System.out.print("\n");
		}
	}
}

/*
1. Space Complexity is very low
2. Time Complexity(Access Time) is more than Adjacency Matrix but difference is less
*/