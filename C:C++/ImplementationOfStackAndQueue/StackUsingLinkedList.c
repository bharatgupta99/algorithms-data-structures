#include<stdio.h>

struct Stack {
	int data;
	struct Stack* next;
};

struct Stack* createNode(int d) {
	struct Stack* s = (struct Stack*)malloc(sizeof(struct Stack));
	s -> data = d;
	s -> next = NULL;
	return s;
}

int isEmpty(struct Stack** s) {
	return *s == NULL;
}

void push(struct Stack** s, int d) {
	struct Stack* temp = createNode(d);
	temp -> next = *s;
	(*s) = temp;  
}

int pop(struct Stack** s) {
	if(isEmpty(s))
		return -999;

	struct Stack* temp = (*s) -> data;
	int d = temp -> data;
	(*s) = (*s) -> next;
	free(temp);
	return d;
}

int peek(struct Stack** s) {
	if(isEmpty(s))
		return -999;

	return (*s) -> data;
}





int main() {
	struct Stack* root = NULL;
	push(&root, 5);
	push(&root, 7);
	push(&root, 8);
	printf("%d\n", pop(&root));
	printf("%d\n", pop(&root));
	printf("%d\n", pop(&root));
	printf("%d\n", peek(&root));
	
}