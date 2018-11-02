#include<iostream>
using namespace std;

void toh(int n, char source, char helper, char destination) {
	if(n == 1){
		cout << "Move disk1 from " << source << " to " << destination << endl; 
		return;
	}
	toh(n - 1, source, destination, helper);
	cout << "Move disk" << n << " from " << source << " to " << destination << endl;
	toh(n - 1, helper, source, destination);
}


int main() {

	toh(10, 'A', 'B', 'C');
	return 0;
}