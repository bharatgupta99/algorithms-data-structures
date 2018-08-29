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

void insert(struct stack* mem, int val) {
	mem->top += 1;
	mem->arr[mem->top] = val;
}

int main() {
	int size = 10;
	struct stack* stck = (struct stack*)malloc(sizeof(struct stack));
	initialize(stck, 10);
	printf("%d\n", isEmpty(stck -> top));
	printf("%d\n", isFull(stck -> top, size - 1));
	insert(stck, 1);
	insert(stck, 2);
	insert(stck, 3);
	insert(stck, 4);
	insert(stck, 5);
	insert(stck, 6);
	insert(stck, 7);
	insert(stck, 8);
	insert(stck, 9);
	insert(stck, 10);
	printf("%d\n", isFull(stck -> top, size - 1));

}