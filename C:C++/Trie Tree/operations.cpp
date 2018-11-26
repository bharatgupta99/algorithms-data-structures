#include<iostream>
#include<string>

using namespace std;

struct TrieNode {
	TrieNode* arr[26];
	bool isEndOfString;	
};

TrieNode* createNode() {
	TrieNode* nn = (TrieNode*)malloc(sizeof(TrieNode));
	for(int i = 0; i < 26; i++) {
		nn -> arr[i] = NULL;
	}
	nn -> isEndOfString = false;
	return nn;
}

void insert(TrieNode* curr, string str) {
	for(int i = 0; i < str.length(); i++) {
		if(curr -> arr[str[i] - 'a']) {
			curr = curr -> arr[str[i] - 'a'];
		}else {
			TrieNode* nn = createNode();
			curr -> arr[str[i] - 'a'] = nn;
			curr = nn;
		}
	}
	curr -> isEndOfString = true;
}

bool search(TrieNode* curr, string str, int index) {
	if(index < str.length() && curr -> arr[str[index] - 'a'] == NULL) {
		return false;
	}

	if(index < str.length()) {
		bool val = search(curr -> arr[str[index] - 'a'], str, index + 1);
		return val;
	}

	if(curr -> isEndOfString)
		return true;
	return false;


}

bool isEmpty(TrieNode* curr) {
	int flag = 0;
	for(int i = 0; i < 26; i++ ) {
		if(curr -> arr[i] != NULL)
			return false;
	}
	return true;
}

bool del(TrieNode* curr, string str, int index) {
	if(index < str.length() && curr -> arr[str[index] - 'a'] == NULL) 
		return false;

	if(index < str.length()) {
		bool val = del(curr -> arr[str[index] - 'a'], str, index + 1);
		
		if(!val) {
			curr -> arr[str[index] - 'a'] = NULL;
		}
		return true;
	}

	if(!isEmpty(curr)) {
		curr -> isEndOfString = false;
		return true;
	}
	return false;
}

int main() {
	TrieNode* root = createNode();
	string s1 = "hello";
	string s2 = "hell";
	string s3 = "helloy";
	insert(root, s1);
	insert(root, s2);
	insert(root, s3);

	cout << search(root, "hello", 0) << endl;

	cout << del(root, "helloy", 0) << endl;
	
	cout << search(root, "helloy", 0) << endl;
	



}