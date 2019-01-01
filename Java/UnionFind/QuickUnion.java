class QuickUnion {

	int[] N;

	public QuickUnion(int n) {
		N = new int[n];
		for(int i = 0; i < n; i++) {
			N[i] = i;
		}
	}

	private int root(int a) {
		while(N[a] != N[N[a]]) {
			a = N[a];
		}
		return N[a];
	}

	public boolean connected(int a, int b) {

		return root(a) == root(b);
	}

	public void union(int parent, int child) {
		int i = root(child);
		int j = root(parent);
		if(i == j) {
			return;
		}
  		N[i] = j;
	}
}