class MaxProfitKTrans {

	private int maxProfit(int[] prices, int k) {
		int[][] maxProfits = new int[k + 1][prices.length];
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j < prices.length; j++) {
				maxProfits[i][j] = -1;
			}

		}
		return maxProfitUtil(prices, k, maxProfits);
	}

	private int maxProfitUtil(int[] prices, int k, int[][] maxProfits) {
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (i == 0 || j == 0) {
					maxProfits[i][j] = 0;
				} else {
					int max = maxProfits[i][j - 1];
					for (int m = 0; m < j; m++) {
						max = Math.max(max, prices[j] - prices[m] + maxProfits[i - 1][m]);
					}
					maxProfits[i][j] = max;
				}
			}
		}
		return maxProfits[k][prices.length - 1];
	}

	public static void main(String[] args) {

		int k = 3;
		int[] prices = {12, 14, 17, 10, 14, 13, 12, 15};

		System.out.println(new MaxProfitKTrans().maxProfit(prices, k));
	}
}