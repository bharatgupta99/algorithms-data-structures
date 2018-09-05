#include<iostream>
#include<stack>

using namespace std;

struct node {
	int data;
	struct node* left;
	struct node* right;
};

void recursive( node* root ) {
	if(root == NULL) return;
	recursive(root->left);
	printf("%d\n", root -> data);
	recursive(root->right);

}


void iterative( node *root) {
	stack<node*> stck;
	node* temp2;
	stck.push(root);
	root = root->left;
	while(1) {
		while(root) {
			stck.push(root);
			root = root -> left;
		}
		if(stck.empty()) break;
		temp2 = stck.top();
		cout << stck.top() -> data << endl;
		stck.pop();
		if(temp2 -> right != NULL) {
			root = temp2 -> right;
		}
	}
}






int main() {

	struct node* n1 = (struct node*) malloc(sizeof(struct node));
	struct node* n2 = (struct node*) malloc(sizeof(struct node));
	struct node* n3 = (struct node*) malloc(sizeof(struct node));
	struct node* n4 = (struct node*) malloc(sizeof(struct node));
	struct node* n5 = (struct node*) malloc(sizeof(struct node));
	struct node* n6 = (struct node*) malloc(sizeof(struct node));
	struct node* n7 = (struct node*) malloc(sizeof(struct node));
	struct node* n8 = (struct node*) malloc(sizeof(struct node));
	struct node* n9 = (struct node*) malloc(sizeof(struct node));
	struct node* n10 = (struct node*) malloc(sizeof(struct node));
	struct node* n11 = (struct node*) malloc(sizeof(struct node));
	struct node* n12 = (struct node*) malloc(sizeof(struct node));
	struct node* n13 = (struct node*) malloc(sizeof(struct node));
	n1->data = 1;
	n2->data = 2;
	n3->data = 3;
	n4->data = 4;
	n5->data = 5;
	n6->data = 6;
	n7->data = 7;
	n8->data = 22;
	n9->data = 8;
	n10->data = 11;
	n11->data = 23;
	n12->data = 9;
	n13->data = 10;
	n1->left = n2;
	n1->right = n3;
	n2->left = n4;
	n2->right = n5;
	n3->left = n6;
	n3->right = n7;
	n4->left = n8;
	n4->right = n9;
	n5->left = NULL;
	n5->right = n10;
	n8->left = n11;
	n8->right = NULL;
	n9->left = n12;
	n9->right = n13;
	n12->left = n12->right = NULL;
	n11->left = n11->right = NULL;
	n13->left = n13->right = NULL;
	n10->left = n10->right = NULL;
	n6->left = n6->right = n7->left = n7->right = NULL;


	node* root = n1;
	iterative(root);



	return 0;
}