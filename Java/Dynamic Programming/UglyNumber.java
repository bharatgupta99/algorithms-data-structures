/*
ugly no's are those which has 2, 3, 5 as multiple
*/

class UglyNumber {
	
	private boolean isUgly(int n) {
		int temp = n;
		while(temp % 2 == 0) {
			temp = temp / 2;
		}
		
		while(temp % 3 == 0) {
			temp = temp / 3;
		}
		
		while(temp % 5 == 0) {
			temp = temp / 5;
		}
		
		return temp == 1 ? true : false;
	}
	
	public int uglyNumberNormal(int n) {
		int i = 1;
		int uglyCount = 1;
		while(uglyCount < n) {
			i++;
			if(isUgly(i)) {
				uglyCount++;
			}
		}
		return i;
	}
	
	public int uglyNumberDP(int n) {
		
		int[] uglyArray = new int[n];
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int multipleOf2 = 2;
		int multipleOf3 = 3;
		int multipleOf5 = 5;
		int uglyNo = 0;
		
		for(int i = 1; i < n; i++) {
			uglyNo = Math.min(Math.min(multipleOf2, multipleOf3), multipleOf5);
			uglyArray[i] = uglyNo;
			
			if(uglyNo == multipleOf2) {
				i2++;
				multipleOf2 = uglyArray[i2] * 2;
			}
			if(uglyNo == multipleOf3) {
				i3++;
				multipleOf3 = uglyArray[i3] * 3;
			}
			if(uglyNo == multipleOf5) {
				i5++;
				multipleOf5 = uglyArray[i5] * 5;
			}
		}
		
		return uglyNo;
	
	}
	
}
