class WeightedQuickUnion {

	int[] N;
	int[] sz;

	public WeightedQuickUnion(int n) {
		N = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++) {
			N[i] = i;
			sz[i] = 1;
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

	public void union(int a, int b) {
		int i = root(a);
		int j = root(b);
		if(i == j) {
			return;
		}
		if(sz[i] > sz[j]) {
			N[j] = i;
			sz[i] += sz[j];
		}else {
			N[i] = j;
			sz[j] += sz[i];
		}
	}
}