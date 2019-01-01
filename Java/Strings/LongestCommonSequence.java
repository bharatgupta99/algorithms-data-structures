class LongestCommonSequence {

	public String findLCS(String input1, String input2) {
		return findLCSUtils(input1, input2, 0, 0);
	}

	private String findLCSUtils(String input1, String input2, int a, int b) {
		if(a >= input1.length() || b >= input2.length()) {
			return "";
		}else if(input1.charAt(a) == input2.charAt(b)) {
			return input1.charAt(a) + findLCSUtils(input1, input2, a + 1, b + 1);
		}
		String result1 = findLCSUtils(input1, input2, a + 1, b);
		String result2 = findLCSUtils(input1, input2, a, b + 1);
		if(result1.length() > result2.length()) {
			return result1;
		}else {
			return result2;
		}
	}

	public static void main(String[] args) {
		LongestCommonSequence sq = new LongestCommonSequence();
		System.out.println(sq.findLCS("ABGDDHBDHBDHCBKSJDBCOBCKJBWECBUECNIEJCIOECOJNEWJKCNKLMCKLNKJCBJKSCJ", "ABCBJBDJNCSDMCASKOPEKLDEJKCNHJEBCHEBYIBENUIWEBCHBDJCBDHD"));
	}
}