import java.util.Iterator;
import java.util.Stack;

public class DFS {

	private boolean[] visited;
	private int[] edgeTo;
	private int source;
	private Stack<Integer> pathStack;
	private UndirectedGraph graph;
	
	public DFS(UndirectedGraph g, int v) {
		source = v;
		graph = g;
		pathStack = new Stack<>();
		visited = new boolean[g.getVerteces()];
		edgeTo = new int[g.getVerteces()];
		
		for(int i = 0; i < g.getVerteces(); i++) {
			visited[i] = false;
			edgeTo[i] = -1;
		}
		DFSTraversalUtils();
		
	}
	
	private void DFSTraversalUtils() {
		DFSTraversal(source);
	}
	
	private void DFSTraversal(int v) {
		Iterator<Integer> iterator = graph.getBag(v).iterator();
		while(iterator.hasNext()) {
			int d = iterator.next();
			if(!visited[d]) {
				visited[d] = true;
				edgeTo[d] = v;
				System.out.println(d);
				DFSTraversal(d);
			}
		}
	}
	
	public boolean isConnected(int v) {
		return visited[v];
	}
	
	public void printPath(int destination) {
		pathStack.push(destination);
		fillStack(destination);
		printStack();
	}
	
	private void fillStack(int destination) {
		if(destination == source) {
			return;
		}else {
			pathStack.push(edgeTo[destination]);
			fillStack(edgeTo[destination]);
		}
	}
	
	private void printStack() {
		while(!pathStack.empty()) {
			System.out.println(pathStack.pop());
		}
	}
}
