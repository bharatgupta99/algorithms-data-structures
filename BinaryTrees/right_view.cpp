#include<iostream>
#include<map>
#include<stack>

using namespace std;

struct node {
	int data;
	node* left;
	node* right;
	int disp;
};

void printRightView(node* root) {
	map<int, int> :: iterator q;


	stack<node*> s;
	map <int, int> m;

	s.push(root);

	while(!s.empty()) {
		node* temp = s.top();
		q = m.find(temp -> disp);
		if(q != m.end()) {
			q -> second = temp -> data;
		}else{
			m.insert( pair<int, int> (temp -> disp, temp -> data) );
		}	
		s.pop();
		if(temp -> right != NULL) {
			temp -> right -> disp = temp -> disp - 1;
			s.push(temp -> right);
		}
		if(temp -> left != NULL) {
			temp -> left -> disp = temp -> disp - 1;
			s.push(temp -> left);
		}
		
	}


	for(q = m.begin(); q != m.end(); q++) {
		cout << q -> second << endl;
	}






}

int main() {

	node* n1 = new node();
	node* n2 = new node();
	node* n3 = new node();
	node* n4 = new node();
	node* n5 = new node();
	node* n6 = new node();
	node* n7 = new node();
	node* n8 = new node();
	node* n9 = new node();
	node* n10 = new node();
	node* n11 = new node();
	node* n12 = new node();
	node* n13 = new node();
	n1->data = 1;
	n2->data = 2;
	n3->data = 3;
	n4->data = 4;
	n5->data = 5;
	n6->data = 6;
	n7->data = 7;
	n8->data = 8;
	n9->data = 9;
	n10->data = 10;
	n11->data = 11;
	n12->data = 12;
	n13->data = 13;
	n1 -> left = n2;
	n1 -> right = n3;
	n2 -> left = n4;
	n2 -> right = n5;
	n4 -> left = n4 -> right = NULL;
	n5 -> left = n5 -> right = NULL;
	n3 -> left = n6;
	n3 -> right = n7;
	n6 -> left = n6 -> right = NULL;
	n7 -> left = n8;
	n7 -> right = NULL;
	n8 -> left = n9;
	n8 -> right = NULL;
	n9 -> left = n10;
	n9 -> right = NULL;
	n10 -> left = n11;
	n10 -> right = NULL;
	n11 -> left = n12;
	n11 -> right = NULL;
	n12 -> left = n13;
	n12 -> right = NULL;
	n13 -> left = NULL;
	n13 -> right = NULL;



	node* root = n1;



	printRightView(root);

}