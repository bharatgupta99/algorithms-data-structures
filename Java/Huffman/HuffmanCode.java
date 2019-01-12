import java.util.*;

public class HuffmanCode {
	
	private HuffmanNode root;
	private HashMap<Character, Integer> counts;
	private HashMap<Character, String> codes;
	private PriorityQueue<HuffmanNode> pQueue;
	private String data;

	public HuffmanCode(String data) {
		counts = new HashMap<Character, Integer>();
		this.data = data;

		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			if (!counts.containsKey(c)) {
				counts.put(c, 1);
			} else {
				counts.put(c, counts.get(c) + 1);
			}
		}

		pQueue = new PriorityQueue<HuffmanNode>(26);
		codes = new HashMap<Character, String>();

		for (Map.Entry<Character, Integer> e : this.counts.entrySet()) {
			pQueue.add(new HuffmanNode(null, null, e.getValue(), e.getKey()));
		}
	}

	private void createHuffmanTree() {
		while (pQueue.size() != 1) {
			HuffmanNode n1 = pQueue.poll();
			HuffmanNode n2 = pQueue.poll();
			pQueue.add(new HuffmanNode(n1, n2, n1.freq + n2.freq, '$'));
		}
		root = pQueue.poll();
	}

	private void getCodes(HuffmanNode r, ArrayList<Integer> store) {
		if (r.right == null && r.left == null) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < store.size(); i++) {
				res.append(String.valueOf(store.get(i)));
			}
			codes.put(r.c, res.toString());
			store.remove(store.size() - 1);
			return;
		}
		store.add(0);
		getCodes(r.left, store);
		store.add(1);
		getCodes(r.right, store);
		if(store.size() != 0)
			store.remove(store.size() - 1);
	}

	public String encodeData() {
		StringBuilder res = new StringBuilder();
		createHuffmanTree();
		getCodes(root, new ArrayList<Integer>());
		for (int i = 0; i < data.length(); i++) {
			res.append(codes.get(data.charAt(i)));
		} 
		return res.toString();
	}

	public HuffmanNode getRoot() {
		return root;
	}

	public String decode(HuffmanNode node, String encode) {
		//decode
		return "A";
	}

}