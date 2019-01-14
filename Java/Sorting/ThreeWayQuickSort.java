public class ThreeWayQuickSort<V extends Comparable<V>> {

	private class Pair {
		int lt, gt;
		private Pair(int lt, int gt) {
			this.lt = lt;
			this.gt = gt;
		}
	}

	public ThreeWayQuickSort(V[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(V[] arr, int l, int h) {
		if (l >= h) {
			return;
		}
		Pair p = partition(arr, l, h);
		sort(arr, l, p.lt - 1);
		sort(arr, p.gt, h);
	}

	private Pair partition(V[] arr, int l, int h) {
		V v = arr[h];
		int i = l, lt = l, gt = h;
		while (i < gt) {
			if(v.compareTo(arr[i]) == 0) {
				i++;
			} else if (v.compareTo(arr[i]) < 0) {
				swap(arr, i, gt);
				gt--;
			} else if (v.compareTo(arr[i]) > 0) {
				swap(arr, i, lt);
				lt++;
				i++;
			}
		}
		Pair p = new Pair(lt, gt);
		return p;
	}

	private void swap(V[] arr, int ai, int bi) {
		V temp = arr[ai];
		arr[ai] = arr[bi];
		arr[bi] = temp;
	}

	public static void main(String[] args) {
		Integer[] arr = {4, -1, 5, 4, 23, 2, 1};
		ThreeWayQuickSort<Integer> qs = new ThreeWayQuickSort<>(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}