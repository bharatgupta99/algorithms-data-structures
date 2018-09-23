#include<iostream>
#include<string>
#include<stack>

using namespace std;

int main() {

	string a = "AB+CD-*";
	int i;
	stack<string> s;

	for( i = 0; i < a.size(); i ++ ) {
		if( a[i] == '(' || a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/' ) {
			string operand1 = s.top();
			s.pop();
			string operand2 = s.top();
			s.pop();

			string temp = a[i] + operand2 +  operand1;

			s.push(temp);

		}else {
			s.push( string(1,a[i]) );
		}

	}

	cout << s.top(); 




}