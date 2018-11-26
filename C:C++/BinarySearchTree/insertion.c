#include<stdio.h>
#include<stdlib.h>

struct BSTNode {
	int data;
	struct BSTNode* left;
	struct BSTNode* right;
};




struct BSTNode* insert(struct BSTNode* root, int d) {
	if(root == NULL) {
		struct BSTNode* nn = (struct BSTNode*)malloc(sizeof(struct BSTNode));
		nn -> data = d;
		nn -> left = NULL;
		nn -> right = NULL;
		return nn;
	}else if(root -> data > d) {
		root -> left = insert(root -> left, d);
	}else {
		root -> right = insert(root -> right, d);
	}
	return root;
}


int main() {
	struct BSTNode* root = NULL;
	root = insert(root, 10);
	root = insert(root, 7);
	root = insert(root, 2);
	root = insert(root, 8);
	root = insert(root, 1);
	root = insert(root, 4);
	root = insert(root, 3);
	root = insert(root, 15);
	root = insert(root, 12);
	root = insert(root, 18);
	root = insert(root, 16);
	root = insert(root, 20);

	//printf("%d", root -> left -> data);
	printf("%d", findMax(root -> left -> left -> left));


}