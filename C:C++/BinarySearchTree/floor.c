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

struct BSTNode* calculateFloor(struct BSTNode* root, int d) {
	if(root == NULL)
		return NULL;
	if(root -> data > d)
		return calculateFloor(root -> left, d);
	if(root -> data == d)
		return root;
	else {
		struct BSTNode* temp = root -> right;
		if(temp != NULL && temp -> data > d && temp -> left != NULL && temp -> left -> data > e)
			return temp;
		else{
			return calculateFloor(temp);
		}

	}

}


int main() {
	struct BSTNode* root = NULL;
	root = insert(root, 10);
	root = insert(root, 5);
	root = insert(root, 3);
	root = insert(root, 6);
	root = insert(root, 8);
	root = insert(root, 12);
	

	//printf("%d", root -> left -> data);
	printf("%d", findMax(root -> left -> left -> left));


}