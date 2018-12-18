import java.util.*;

class TrieSuggestions {

	Node head;

	class Node {
		Map<Character, Node> m;
		boolean endOfString;
		public Node() {
			m = new HashMap<>();
			endOfString = false;
		}
	}

	public TrieSuggestions() {
		head = new Node();
	}

	public void insert(String input) {
		Node crawler = head;
		for(int i = 0; i < input.length(); i++) {
			if(!crawler.m.containsKey(input.charAt(i))) {
				crawler.m.put(input.charAt(i), new Node());
			}
			crawler = crawler.m.get(input.charAt(i));
		}
		crawler.endOfString = true;

	}

	public boolean search(String input) {
		Node crawler = head;
		for(int i = 0; i < input.length(); i++) {
			if(!crawler.m.containsKey(input.charAt(i))) {
				return false;
			}
			crawler = crawler.m.get(input.charAt(i));
		}
		return crawler.endOfString;
	}

	public void suggestions(String input, ArrayList<String> res) {
		Node crawler = head;
		for(int i = 0; i < input.length(); i++) {
			if(!crawler.m.containsKey(input.charAt(i))) {
				return;
			}
			crawler = crawler.m.get(input.charAt(i));
		}
		if(crawler.endOfString) {
			res.add(input);
		}

		for(Map.Entry<Character, Node> entry : crawler.m.entrySet()) {

			suggestions(input + entry.getKey(), res);
		}
	}

	public static void main(String[] args) {
		TrieSuggestions trie = new TrieSuggestions();

		trie.insert("bharat");
		trie.insert("butter");
		trie.insert("bread");
		trie.insert("breed");
		trie.insert("milk");
		trie.insert("cake");
		trie.insert("pizza");
		trie.insert("bhang");
		trie.insert("beer");
		trie.insert("coke");
		trie.insert("call");
		trie.insert("egg");
		trie.insert("energy");

		ArrayList<String> res = new ArrayList<>();
		trie.suggestions("c", res);
		System.out.println(res);

	}
}