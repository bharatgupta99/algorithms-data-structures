class PathToZero {

	private int countPath(int n, int parent) {
		if (n == 0) {
			return 1;
		}

		int c1 = rightMostFlip(n);
		int c2 = otherFlip(n);

		if (c1 == parent) {
			return 1 + countPath(c2, n);
		}
		if (c2 == parent) {
			return 1 + countPath(c1, n);
		}

		return 
	}

	public static void main(String[] args) {
		int n = 5;
		int count = countPath(n, -1);
		System.out.println(count);
	}
}