import java.util.Iterator;

public class UndirectedGraph {
	private int v;
	private Bag[] adj;
	private boolean selfLoop;
	private boolean[] marked;
	private int[] edgeTo;
	
	public UndirectedGraph(int v) {
		this.v = v;
		this.selfLoop = false;
		adj = new Bag[v];
		marked = new boolean[v];
		edgeTo = new int[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new Bag();
			marked[i] = false;
			edgeTo[i] = -1;
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].enqueue(w);
		
		//check for self loop
		if(v != w) {
			adj[w].enqueue(v);
		}else {
			selfLoop = true;
		}
		
	}
	
	public boolean hasSelfLoop() {
		return selfLoop;
	}
	
	public int getVerteces() {
		return v;
	}
	
	public int degree(int v) {
		int count = 0;
		Iterator<Integer> iterator = adj[v].iterator();
		while(iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}

	
	public Bag getBag(int i) {
		return adj[i];
	}

}
