#include<stack>
#include<iostream>

using namespace std;
int presedence(char a) {

	if( a == '*' || a == '/' ){
		return 2;
	}else if( a == '+' || a == '-') {
		return 1;
	}
	return -1;

}

int main() {
	char *a = "a+b*c+d";
	stack<char> s;
	char *res = (char*)malloc( sizeof(char) * strlen(a) );
	int i, index = 0;
	for( i = 0; a[i] != '\0'; i ++ ) {
		if( ( a[i] >= 'a' && a[i] <= 'z' ) || ( a[i] >= 'A' && a[i] <= 'Z' ) ) {
			res[index++] = a[i];
		}
		else if( a[i] == '(' || a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/' ) {
			if(s.empty()) {
				s.push(a[i]);
			}else {
				if( presedence(a[i]) > presedence(s.top()) ) {
					s.push(a[i]);
				}else {
					while(!s.empty() && presedence(a[i]) <= presedence(s.top()) ) {
						res[index++] = s.top();
						s.pop();
					}
					s.push(a[i]);
				}
			}
		}
	}
	while(!s.empty()) {
		res[index++] = s.top();
		s.pop();
	}
	for( i = 0; i < index; i ++ ) {
		printf("%c ", res[i] );
	}
}



