public class TestGraph {
	
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(13);
		g.addEdge(0, 5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		g.addEdge(3, 5);
		g.addEdge(3, 4);
		g.addEdge(5, 4);
		g.addEdge(6, 4);
		g.addEdge(7, 8);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(11, 12);
		
		System.out.println(g.getVerteces());
		System.out.println(g.degree(0));		
		System.out.println(g.hasSelfLoop());
		
		//do dfs and then check connections
		DFS dfs0 = new DFS(g, 0);
		System.out.println(dfs0.isConnected(4));
		dfs0.printPath(3);
		System.out.println("-------------------------");
		dfs0.printPath(5);
		
		System.out.println("-------------------------");
		
		DFS dfs7 = new DFS(g, 7);
		System.out.println(dfs7.isConnected(9));
		dfs7.printPath(8);
	}
}
