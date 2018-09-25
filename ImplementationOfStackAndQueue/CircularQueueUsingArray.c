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

void enqueue(struct Queue* q, int data) {
	if(isFull(q))
		return;

	(q -> size) ++;
	(q -> tail) = (q -> tail + 1 ) % (q -> capacity);
	q -> a[q -> tail] = data;
}

int dequeue(struct Queue *q) {
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

	enqueue(q, 1);
	enqueue(q, 2);
	enqueue(q, 3);
	enqueue(q, 4);
	enqueue(q, 5);
	enqueue(q, 6);
	enqueue(q, 7);
	enqueue(q, 8);
	enqueue(q, 9);
	enqueue(q, 10);
	printf("%d\n", dequeue(q));
	enqueue(q, 11);

	printf("%d\n", peek(q));
	
}