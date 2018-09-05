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
	printf("%d\n", root -> data);
	recursive(root->left);
	recursive(root->right);

}


void iterative( node *root) {

	stack<node*> stck;
	stck.push(root);

	while(!stck.empty()) {
		node *temp = stck.top();
		cout << stck.top() -> data <<endl;
		stck.pop();
		if( temp -> right != NULL ) {
			stck.push(temp -> right);
		}
		if( temp -> left != NULL) {
			stck.push(temp -> left);
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
	n1->data = 1;
	n2->data = 2;
	n3->data = 3;
	n4->data = 4;
	n5->data = 5;
	n6->data = 6;
	n7->data = 7;
	n1->left = n2;
	n1->right = n3;
	n2->left = n4;
	n2->right = n5;
	n3->left = n6;
	n3->right = n7;
	n4->left = NULL;
	n4->right = NULL;
	n5->left = NULL;
	n5->right = NULL;
	n6->left = NULL;
	n6->right = NULL;
	n7->left = NULL;
	n7->right = NULL;

	struct node *root = n1;
	recursive(root);
	printf("------\n");
	iterative(root);

	return 0;
}