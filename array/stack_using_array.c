#include<stdio.h>
#include<stdlib.h>

struct stack {
	int *arr;
	int top;
};

void initialize( struct stack* mem, int len ) {
	mem -> arr = (int *)malloc(sizeof(int) * len);
	mem -> top = -1;
}

int isEmpty(int top) {
	if( top == -1 ) return 1;
	return 0;
}

int isFull(int top, int size) {
	if(top == size) return 1;
	return 0;
}

void push(struct stack* mem, int val) {
	mem->top += 1;
	mem->arr[mem->top] = val;
}

void pop(struct stack *mem) {
	mem->top = mem->top - 1;
}

int getTop(struct stack *mem) {
	int val = mem->arr[mem->top];
	return val;
}

int main() {
	int size = 10;
	struct stack* stck = (struct stack*)malloc(sizeof(struct stack));
	initialize(stck, 10);
	printf("%d\n", isEmpty(stck -> top));
	printf("%d\n", isFull(stck -> top, size - 1));
	push(stck, 1);
	push(stck, 2);
	push(stck, 3);
	push(stck, 4);
	push(stck, 5);
	push(stck, 6);
	push(stck, 7);
	push(stck, 8);
	push(stck, 9);
	push(stck, 10);
	pop(stck);
	printf("%d\n", getTop(stck));

}