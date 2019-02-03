class countSubsetToSum {

	private static int count(int[] input, int index, int sum) {
		if (sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}
		if (index == input.length) {
			return 0;
		}
		return count(input, index + 1, sum - input[index]) + count(input, index + 1, sum);
	}

	public static void main(String[] args) {
		int input[] = {2, 4, 6, 10, 16};
		int sum = 16;
		int res = count(input, 0, sum);
		System.out.println(res);
	}


}