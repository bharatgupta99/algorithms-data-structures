#include<stdlib.h>
#include<stdio.h>

struct node {
	struct node* next;
	int data;
};

void push( struct node **end, struct node** start, int data) {
	struct node* newNode = (struct node*)malloc(sizeof(struct node));
	newNode -> data = data;
	newNode -> next = NULL;

	if( *start == NULL ) {
		*start = newNode;
		*end = newNode;
	}else{
		(*end) -> next = newNode;
		*end = newNode;
	}
}

void pop(struct node** start) {
	if(start == NULL ) return ;
	*start = (*start) -> next;
}


int main() {
	struct node* start = NULL;
	struct node* end = NULL;
	push(&end, &start, 2);
	push(&end, &start, 3);
	push(&end, &start, 4);
	push(&end, &start, 5);
	push(&end, &start, 6);
	pop(&start);

	printf("%d\n", start -> data );
	
}