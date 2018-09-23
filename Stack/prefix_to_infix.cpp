#include<stack>
#include<iostream>
#include<string>

using namespace std;


int main() {
	stack<string> s;
	string a = "*-A/BC-/AKL";
	int i;
	for( i = a.size() - 1; i >= 0; i -- ) {
		if( a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/' ) {
			string operand1 = s.top();
			s.pop();
			string operand2 = s.top();
			s.pop();
			string temp = "(" + operand1 + a[i] + operand2 + ")" ;
			s.push(temp);
		}else {
			s.push(string(1, a[i]));
		}
	}

	cout << s.top();


}