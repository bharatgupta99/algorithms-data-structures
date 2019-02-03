class NumberOfBST {

	private int countBST(int n) {
		
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			arr[i] = 0;
			for (int j = 0; j < i; j++) {
				arr[i] += arr[j] * arr[i - j - 1];
			}
		}

		return arr[n];

	}

	public static void main(String[] args) {
		int n = 4;
		int res = new NumberOfBST().countBST(n);
		System.out.println(res);
	}
}