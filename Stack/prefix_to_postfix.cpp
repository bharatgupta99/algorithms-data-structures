#include<stack>
#include<iostream>

using namespace std;

int main() {

	char *a = "*+AB-CD";
	stack<char> s;
	char *res = (char*)malloc(sizeof(char) * strlen(a));
	int i, index = 0;
	for( i = 0; a[i] != '\0'; ) {
		if( a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/' ) {
			s.push(a[i]);
			i ++;
		}else {
			while( ( a[i] >= 'a' && a[i] <= 'z' ) || ( a[i] >= 'A' && a[i] <= 'Z') ) {
				res[index ++] = a[i];
				i++;
			}
			res[index ++] = s.top();
			s.pop();
		}
	}

	while( !s.empty() ) {
		res[index ++] = s.top();
		s.pop();
	}
	res[index] = '\0';
	cout << res;
}