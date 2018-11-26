#include <iostream>
#include <string>

using namespace std;

string keypad(int n) {
	switch(n) {
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8: 
			return "tuv";
		case 9:
			return "wxyz";
		default:
			return "";
	}
}


string* keypadCombinations(int input, int* sz) {
	if(input < 10) {
		string res = keypad(input);
		*sz = res.length();
		string* output = new string[res.length()];
		for(int i = 0; i < res.length(); i++) {
			output[i] = res[i];
		}
		return output;
	}
	string* output = keypadCombinations(input / 10, sz);
	string temp = keypad(input % 10);
	string* combinedOutput = new string[*sz * temp.length()];
	int index = 0;
	for(int i = 0; i < *sz; i++) {
		for(int j = 0; j < temp.length(); j++) {
			combinedOutput[index++] = output[i] + temp[j];
		}
	}
	*sz = *sz * temp.length(); 
	return combinedOutput;

}

int main() {
	int sz = 0;
	string* res = keypadCombinations(23545, &sz);
	for(int i = 0; i < sz; i++) {
		cout << res[i] << endl;
	}
}