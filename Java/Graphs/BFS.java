import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	
	private UndirectedGraph g;
	private boolean[] visited;
	private int[] edgeTo;
	private Stack<Integer> pathStack;
	private Queue<Integer> q;
	private int source;
	
	public BFS(UndirectedGraph g, int start) {
		this.g = g;
		q =  new LinkedList<>();
		source = start;
		visited = new boolean[g.getVerteces()];
		edgeTo = new int[g.getVerteces()];
		pathStack = new Stack<>();
		for(int i = 0; i < g.getVerteces(); i++) {
			visited[i] = false;
			edgeTo[i] = -1;
		}
		BFSTraversal(start);
	}
	
	public void BFSTraversal(int start) {
		visited[start] = true;
		q.add(start);
		BFSTraversalUtil();
	}
	
	public void BFSTraversalUtil() {
		while(!q.isEmpty()) {
			int top = q.poll();
			Iterator<Integer> iterator = g.getBag(top).iterator();
			while(iterator.hasNext()) {
				int temp = iterator.next();
				if(!visited[temp]) {
					q.add(temp);
					System.out.println(temp);
					visited[temp] = true;
					edgeTo[temp] = top;
				}
			}
		}
	}
	
	private void shortestPath(int destination) {
		if(destination == source) {
			pathStack.push(destination);
			return;
		}else {
			pathStack.push(destination);
			shortestPath(edgeTo[destination]);
		}
	}
	
	public void printShortestPath(int destination) {
		shortestPath(destination);
		while(!pathStack.isEmpty()) {
			System.out.println(pathStack.pop());
		}
	}
}
