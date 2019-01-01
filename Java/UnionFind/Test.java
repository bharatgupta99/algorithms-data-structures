class Test {
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(0, 8);
		qf.union(6, 2);
		qf.union(2, 5);
		qf.union(5, 3);
		qf.union(5, 9);
		qf.union(9, 1);
		qf.union(1, 7);
		System.out.println(qf.connected(4, 8));	

		QuickUnion qu = new QuickUnion(10);
		qu.union(0, 8);
		qu.union(6, 2);
		qu.union(2, 5);
		qu.union(5, 3);
		qu.union(5, 9);
		qu.union(9, 1);
		qu.union(1, 7);
		System.out.println(qu.connected(2, 8));	

		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		wqu.union(0, 8);
		wqu.union(6, 2);
		wqu.union(2, 5);
		wqu.union(5, 3);
		wqu.union(5, 9);
		wqu.union(9, 1);
		wqu.union(1, 7);
		System.out.println(wqu.connected(0, 8));	
	}
}