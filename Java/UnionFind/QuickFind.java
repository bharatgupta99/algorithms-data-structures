class QuickFind {

	int[] N;

	public QuickFind(int n) {
		N = new int[n];
		for(int i = 0; i < n; i++) {
			N[i] = i;
		}
	}

	public boolean connected(int a, int b) {
		return N[a] == N[b];
	}

	public void union(int a, int b) {
		if(find(a, b)) {
			return;
		}
		int bVal = N[b];
		int aVal = N[a];

		for(int i = 0; i < N.length; i++) {
			if(N[i] == aVal) {
				N[i] = bVal;
			}
		}

	}
}