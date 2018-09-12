#include<iostream>
#include<stack>
using namespace std;

int main() {
	char* a = "{()}[]";
	stack<char> s1;
	char c;
	int i, flag = 1;
	for( i = 0; i < strlen(a); i ++ ) {
		if( a[i] == '{' || a[i] == '[' || a[i] == '(' ) {
			s1.push(a[i]);
		}else{
			switch(a[i]) {
				case '}':
					c = '{';
					break;
				case ']':
					c = '[';
					break;
				case ')':
					c = '(';
					break;
				default: 
					c = 'a';
			};

			if( s1.top() != c) {
				flag = 0;
				break;
			}else{
				s1.pop();
			}
			

		}

	}

	if(flag) printf("YES");	
	else printf("NO");


}