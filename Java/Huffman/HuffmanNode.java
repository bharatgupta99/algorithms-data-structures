public class HuffmanNode implements Comparable<HuffmanNode>{
	HuffmanNode left;
	HuffmanNode right;
	int freq;
	char c;

	public HuffmanNode(HuffmanNode left, HuffmanNode right, int freq, char c) {
		this.left = left;
		this.right = right;
		this.freq = freq;
		this.c = c;
	}

	public int compareTo(HuffmanNode n) {
		return this.freq - n.freq;
	}
}