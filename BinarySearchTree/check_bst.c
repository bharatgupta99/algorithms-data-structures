#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct BSTNode {
	int data;
	struct BSTNode* left;
	struct BSTNode* right;
};

int findMax(struct BSTNode* root) {
	if(root -> left == NULL) 
		return root -> data;
	else{
		struct BSTNode* temp = root -> left;
		int d = 0;
		while(temp) {
			d = temp -> data;
			temp = temp -> right;
		}
		return d;
	}
}

int findMin(struct BSTNode* root) {
	if(root -> right == NULL)
		return root -> data;
	else{
		struct BSTNode* temp = root -> right;
		int d = 0;
		while(temp) {
			d = temp -> data;
			temp = temp -> left;
		}
		return d;
	}
}

//efficient method O(n)
int checkBST2(struct BSTNode* root, int min, int max) {
	if(root == NULL)
		return 1;
	else if(root -> data < min || root -> data > max)
		return 0;
	return checkBST2(root -> left, min, root -> data) && checkBST2(root -> right, root -> data, max);
}





//inefficient method O(n^2)
int checkBST(struct BSTNode* root) {
	if(root  == NULL)
		return 1;
	else if(root -> data < findMax(root) || root -> data > findMin(root))
		return 0;

	return checkBST(root -> left) && checkBST(root -> right);

	


}


int main() {

	//data and memory allocation
	struct BSTNode* n1 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n1 -> data = 10;
	struct BSTNode* n2 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n2 -> data = 7;
	struct BSTNode* n3 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n3 -> data = 15;
	struct BSTNode* n4 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n4 -> data = 2;
	struct BSTNode* n5 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n5 -> data = 8;
	struct BSTNode* n6 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n6 -> data = 12;
	struct BSTNode* n7 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n7 -> data = 18;
	struct BSTNode* n8 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n8 -> data = 1;
	struct BSTNode* n9 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n9 -> data = 4;
	struct BSTNode* n10 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n10 -> data = 16;
	struct BSTNode* n11 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n11 -> data = 20;
	struct BSTNode* n12 = (struct BSTNode*)malloc(sizeof(struct BSTNode));
	n12 -> data = 3;

	//connections
	n1 -> left = n2;
	n1 -> right = n3;
	n2 -> left = n4;
	n2 -> right = n5;
	n3 -> left = n6;
	n3 -> right = n7;
	n4 -> left = n8;
	n4 -> right = n9;
	n5 -> left = NULL;
	n5 -> right = NULL;
	n6 -> left = NULL;
	n6 -> right = NULL;
	n7 -> left = n10;
	n7 -> right = n11;
	n8 -> left = NULL;
	n8 -> right = NULL;
	n9 -> left = n12;
	n9 -> right = NULL;
	n10 -> left = n10 -> right = NULL;
	n11 -> left = n11 -> right = NULL;
	n12 -> left = n12 -> right = NULL;

	
	struct BSTNode* root = n1;

	printf("%d\n", checkBST2(root, INT_MIN, INT_MAX));
	printf("%d\n", checkBST(root));


}