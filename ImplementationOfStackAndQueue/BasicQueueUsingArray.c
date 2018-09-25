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

void push(struct Queue* q, int d) {
	if(isFull(q))
		return;

	(q -> size) ++;
	++ (q -> tail);
	q -> a[q -> tail] = d;
}

int pop(struct Queue* q) {
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
	printf("%d\n", pop(q));
	push(q, 11);

	printf("%d", peek(q));

}