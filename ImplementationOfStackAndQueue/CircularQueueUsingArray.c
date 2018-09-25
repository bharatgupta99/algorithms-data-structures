#include<stdio.h>
#include<stdlib.h>

struct Queue {
	int tail, head, size;
	int capacity;
	int* a;
};

struct Queue* createNode(int capacity) {
	struct Queue* q = (struct Queue*)malloc(sizeof(struct Queue));
	q -> capacity = capacity;
	q -> tail = -1;
	q -> head = -1;
	q -> a = (int*)malloc(sizeof(int) * capacity);
	q -> size = 0;
	return q;
}

int isEmpty(struct Queue* q) {
	return q -> size == 0;
}

int isFull(struct Queue *q) {
	return q -> size == q -> capacity;
}

void push(struct Queue* q, int data) {
	if(isFull(q))
		return;

	(q -> size) ++;
	(q -> tail) = (q -> tail + 1 ) % (q -> capacity);
	q -> a[q -> tail] = data;
}

int pop(struct Queue *q) {
	if(isEmpty(q))
		return -999;

	(q -> size) --;
	(q -> head) = (q -> head + 1) % (q -> capacity);
	return q -> a[q -> head];
}

int peek(struct Queue *q) {
	if(isEmpty(q))
		return -999;

	return q -> a[q -> tail];
}



int main() {
	struct Queue* q = createNode(10);

	push(q, 1);
	push(q, 2);
	push(q, 3);
	push(q, 4);
	push(q, 5);
	push(q, 6);
	push(q, 7);
	push(q, 8);
	push(q, 9);
	push(q, 10);
	printf("%d\n", pop(q));
	push(q, 11);

	printf("%d\n", peek(q));
	
}