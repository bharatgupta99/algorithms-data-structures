import java.util.HashMap;
import java.util.Map;

public class TrieTree {
	
	private TrieNode head;
	
	public TrieTree() {
		head = new TrieNode();
	}
	
	public class TrieNode {
		Map<Character, TrieNode> m;
		boolean endOfString;
		public TrieNode() {
			m = new HashMap<>();
			endOfString = false;
			for(int i = 0; i < 26; i++) {
				m.put((char)(i + 97), null);
			}
		}
	}
		
	public void insert(String input) {
		TrieNode temp = head;
		for(int i = 0; i < input.length(); i++) {
			if(temp.m.get(input.charAt(i)) == null) {
				temp.m.put(input.charAt(i), new TrieNode());
			}	
			temp = temp.m.get(input.charAt(i));
		}
		temp.endOfString = true;
	}
	
	public boolean search(String input) {
		TrieNode temp = head;
		for(int i = 0; i < input.length(); i++) {
			if(temp.m.get(input.charAt(i)) == null) {
				return false;
			}else {
				temp = temp.m.get(input.charAt(i));
			}
		}	
		return temp.endOfString;
	}
	
	
	
}
