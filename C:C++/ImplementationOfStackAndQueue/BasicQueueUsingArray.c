#include<stdio.h>
#include<stdlib.h>

struct Queue {
	int size;
	int capacity;
	int tail, head;
	int* a;
};

struct Queue* createQueue(int capacity) {
	struct Queue* temp = (struct Queue*)malloc(sizeof(struct Queue));
	temp -> capacity = capacity;
	temp -> a = (int*)malloc(sizeof(int) * capacity);
	temp -> tail = -1;
	temp -> head = -1;
	temp -> size = 0;
	return temp;
}

int isFull(struct Queue* q) {
	return (q -> tail) == (q -> capacity) - 1;
}

int isEmpty(struct Queue *q) {
	return q -> size == 0;

}

void enqueue(struct Queue* q, int d) {
	if(isFull(q))
		return;

	(q -> size) ++;
	++ (q -> tail);
	q -> a[q -> tail] = d;
}

int dequeue(struct Queue* q) {
	if(isEmpty(q))
		return -999;
	(q -> size) --;
	(q -> head) ++;
	return q -> a[q -> head];
}

int peek(struct Queue* q) {
	if(isEmpty(q))
		return -999;

	return q -> a[q -> tail];
}




int main() {

	struct Queue* q = createQueue(10);

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
	printf("%d\n", dequeue(q));
	enqueue(q, 11);

	printf("%d", peek(q));

}