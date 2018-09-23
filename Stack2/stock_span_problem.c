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
	int a[7] = {4, 9, 0, 2, 1, 6, 2};
	struct stack *stck = (struct stack*)malloc(sizeof(struct stack));
	initialize(stck, 6);
	push(stck, 0);
	int i, span[7];
	int largest = 1;
	span[0] = 1;
	for( i = 1; i < 7; ) {
		if( a[i] <= a[getTop(stck)]) {
			span[i] = i - getTop(stck);
			if(span[i] > largest) largest = span[i];
			push(stck, i);
			i ++;
		}else {
			pop(stck);
			
		}

		//Empty check
		if(isEmpty(stck -> top)) {
			span[i] = i + 1;
			if(span[i] > largest) largest = span[i];
			int k;
			for( k = 0; k <= i; k ++ ){
				push(stck, k);
			}
			i++;
		}

	}

	printf("%d\n", largest);
}