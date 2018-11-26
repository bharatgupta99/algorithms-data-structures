#include<stdio.h>
#include<stdlib.h>

struct stck {
	int top;
	int *a;
	int capacity;
};

struct stck* createStack(int length) {
	struct stck* s = (struct stck*)malloc(sizeof(struct stck));
	s -> top = -1;//index of element at top.
	s -> capacity = length; //maximum no. of element the stack can contain.
	s -> a = (int*)malloc(sizeof(int) * length);//array to store elements
	return s;
}

int isFull(struct stck* s) {
	return s -> top == s -> capacity - 1;
}

int isEmpty(struct stck* s) {
	return s -> top == -1;
}

void push(struct stck* s, int d) {
	if(isFull(s)) {
		printf("Stack is full\n");
		return;
	}
	s -> top = s -> top + 1;
	s -> a[s -> top] = d;
}

int pop(struct stck* s) {
	if(isEmpty(s))
		return -999;
	int temp = s -> a[s -> top];
	s -> top --;
	return temp;
}

int peek(struct stck *s) {
	if(isEmpty(s)) {
		printf("stack is empty\n");
		return -999;
	}

	return s -> a[s -> top];

}
int main() {

	struct stck* s = createStack(3);
	push(s, 4);
	push(s, 6);
	push(s, 7);
	push(s, 8);
	pop(s);
	pop(s);
	pop(s);
	printf("%d\n",peek(s));



}