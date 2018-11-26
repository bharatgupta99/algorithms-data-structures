public class FibonacciSeries {
	
	
	//lots of recalculations
	//Time O(2^n)
	public int fibonacciRecursion(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacciRecursion(n-1) + fibonacciRecursion(n - 2);
	}
	
	//no recalculations Time - O(n) Space - O(n)
	public int fibonacciMemoization(int n) {
		int[] mem = new int[n];
		for(int i = 0; i < n; i++) {
			mem[i] = -1;
		}
		return fibonacciMemoizationMain(n, mem);
	}
	
	public int fibonacciMemoizationMain(int n, int[] mem) {
		if(mem[n - 1] != -1) {
			return mem[n - 1];
		}
		int res;
		if(n == 1 || n == 2) {
			res = 1;
		}else {
			res = fibonacciMemoizationMain(n - 1, mem) + fibonacciMemoizationMain(n - 2, mem);
		}
		mem[n - 1] = res;
		return res;
	}
	
	//no recalculations Time - O(n) Space - O(1) 
	public int bottomsUp(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		int res = 0;
		int a = 1;
		int b = 1;
		for(int i = 2; i < n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
	
}
