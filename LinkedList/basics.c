#include<stdio.h>


struct node {
	int data;
	struct node *next;
};

struct node *pointerToheadNode = NULL;

void insertFirst(int x){
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	temp->data = x;
	temp->next = pointerToheadNode;
	pointerToheadNode = temp;
}

void insertLast(int x){
	
	if(pointerToheadNode == NULL) insertFirst(x);
	else{
		struct node *temp = (struct node*)malloc(sizeof(struct node));
		temp->data = x;
		struct node *currentNode = pointerToheadNode;
		while(currentNode->next){
			currentNode = currentNode->next;
		}
		temp->next = NULL;
		currentNode->next = temp;

	}
}

void insert(int x, int index){
	
	if(index==0 || pointerToheadNode == NULL) insertFirst(x);
	else{
		struct node *temp = (struct node*)malloc(sizeof(struct node));
		temp->data = x;
		int i=0;
		struct node *currentNode = pointerToheadNode;
		while(i<index-1){
			currentNode = currentNode->next;
			i++;
		}
		temp->next = currentNode->next;
		currentNode->next = temp;
	}
}

int main(){
	insertFirst(50);
	insertFirst(40);
	insertFirst(30);
	insertFirst(20);
	insertFirst(10);
	insert(12,5);
	insertLast(60);

	int i;
	while(pointerToheadNode){
		printf("%d\n", pointerToheadNode->data);
		pointerToheadNode = pointerToheadNode->next;
		
	}	

	return 0;

}