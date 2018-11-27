class LongestCommonSequence {

	//Normal REcursive Way
	public String findLCS(String input1, String input2) {
		return findLCSUtil(input1, input2, 0, 0);
	}

	private String findLCSUtil(String input1, String input2, int a, int b) {
		if(a >= input1.length() || b >= input2.length()) {
			return "";
		}else if(input1.charAt(a) == input2.charAt(b)) {
			return input1.charAt(a) + findLCSUtil(input1, input2, a + 1, b + 1);
		}
		String result1 = findLCSUtil(input1, input2, a + 1, b);
		String result2 = findLCSUtil(input1, input2, a, b + 1);
		if(result1.length() > result2.length()) {
			return result1;
		}else {
			return result2;
		}
	}



	//Memoization in String 2D Array
	public String findLCSwithDP(String input1, String input2) {
		String[][] mem = new String[input1.length()][input2.length()];
		for(int i = 0; i < input1.length(); i++) {
			for(int j = 0; j < input2.length(); j++) {
				mem[i][j] = null;
 			}
		}
		return findLCSUtilDP(input1, input2, 0, 0, mem);
	}

	private String findLCSUtilDP(String input1, String input2, int a, int b, String[][] mem) {
		if(a >= input1.length() || b >= input2.length()) {
			return "";
		}else if(input1.charAt(a) == input2.charAt(b)) {
			if(mem[a][b] != null) {
				return mem[a][b];
			}else{
				String res = input1.charAt(a) + findLCSUtilDP(input1, input2, a + 1, b + 1, mem);
				mem[a][b] = res;
				return res;
			}
		}
		if(mem[a][b] != null) {
			return mem[a][b];
		}else{
			String result1 = findLCSUtilDP(input1, input2, a + 1, b, mem);
			String result2 = findLCSUtilDP(input1, input2, a, b + 1, mem);
			if(result1.length() > result2.length()) {
				mem[a][b] = result1;
				return mem[a][b];
			}else {
				mem[a][b] = result2;
				return mem[a][b];
			}		
		}
	}

	public static void main(String[] args) {
		LongestCommonSequence sq = new LongestCommonSequence();

		//These inputs will not working with RECURSIVE LCS
		System.out.println(sq.findLCSwithDP("JHBSDJHBSJKDNCNRCJKENDCNWODICNJWDNCKWBDHJCEJCNIUEBRJKFNEIRVFJWEBFNWEIF", "JHDBCJHWDKJCBWDICBWKDCKWJHDCBWDKLCNIUWDCHJKWDJKCWDCKJIOWDHPOWJEHURHBWEBFHJWF"));
	}
}