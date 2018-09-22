#include<iostream>
#include<vector>
using namespace std;


struct node {
	int data;
	struct node* left;
	struct node* right;
};

void printVector(vector<int> A) {
	for(int i = 0; i < A.size(); i ++) {
		cout << A[i] << " ";
	}
	cout << endl;
}

void printAllPaths(node* root, vector<int>& A) {
	if(root == NULL)
		return;

	A.push_back(root -> data);

	if(root -> left == NULL && root -> right ==  NULL) {
		printVector(A);
		A.pop_back();
		return;
	}

	printAllPaths(root -> left, A);
	printAllPaths(root -> right, A);

}



int main() {

	node* n1 = new node();
	node* n2 = new node();
	node* n3 = new node();
	node* n4 = new node();
	node* n5 = new node();
	node* n6 = new node();

	n1 -> data = 10;
	n1 -> left = n2;
	n1 -> right = n3;

	
	n2 -> data = 8;
	n2 -> left = n4;
	n2 -> right = n5;

	
	n3 -> data = 2;
	n3->left = n6;
	n3->right = NULL;

	
	n4 -> data = 3;
	n4->left = NULL;
	n4->right = NULL;

	
	n5 -> data = 5;
	n5->left = NULL;
	n5->left = NULL;
	
	
	n6 -> data = 2;
	n6->left = NULL;
	n6->left = NULL;

	node* root = n1;

	vector<int> v;
	printAllPaths(root, v);



	return 0;
}