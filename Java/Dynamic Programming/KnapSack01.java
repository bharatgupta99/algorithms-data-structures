class KnapSack01 {

	public int KS(int[] w, int[] v, int c) {
		int n = w.length;
		int[][] dp = new int[n + 1][c + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < c + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return KSUtil(w, v, n - 1, c, dp);
	}

	private int KSUtil(int[] w, int[] v, int n, int c, int[][] dp) {
		if (dp[n][c] != -1) {
			return dp[n][c];
		}
		if (n == 0 || c <= 0) {
			if (c == 0) {
				dp[n][c] = 0;
			}
			return 0;
		}
		int res = Math.max(v[n] + KSUtil(w, v, n - 1, c - w[n], dp), KSUtil(w, v, n - 1, c, dp));
		dp[n][c] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] w = {10, 20, 30};
		int[] v = {60, 100, 120};
		int c = 50;


		System.out.println(new KnapSack01().KS(w, v, c));
	}
}