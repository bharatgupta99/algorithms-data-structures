import java.util.ArrayList;

class FindSubsets {

	private static void findSubsets(int[] input, int sz, ArrayList<ArrayList<Integer>> res) {
		
		if (sz == 0) {
			res.add(new ArrayList<>());
			return;
		} 

		findSubsets(input, sz - 1, res);
		int a = res.size();
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> storage = new ArrayList<>();
			ArrayList<Integer> t = res.get(i);
			for (int j = 0; j < t.size(); j++) {
				storage.add(t.get(j));
			}
			storage.add(input[sz - 1]);
			res.add(storage);
		}
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4};
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		findSubsets(input, input.length, res);

		System.out.println(res);
	}
}