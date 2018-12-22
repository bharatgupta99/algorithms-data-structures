class LongestIncreasingSubsequence {
	public static void longestIncreasingSubsequence(int[] a, int[] lis, int i) {
		if(i == a.length) {
			return;
		}
		int maxInc = 0;
		for(int j = 0; j < i; j++) {
			if(a[j] < a[i] && maxInc < lis[j]) {
				maxInc = lis[j];
			}
		}
		lis[i] = maxInc + 1;
		longestIncreasingSubsequence(a, lis, i + 1);

	}

	public static void main(String[] args) {
		int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] lis = new int[a.length];
		longestIncreasingSubsequence(a, lis, 0);
		for(int i = 0; i < lis.length; i++) {
			System.out.print(lis[i]);
			System.out.print(' ');
		}
	}
}