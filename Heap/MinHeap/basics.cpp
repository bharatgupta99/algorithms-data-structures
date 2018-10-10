#include<iostream>

using namespace std;

void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

class MinHeap {
public:
	int* heapArray;
	int capacity;
	int heapSize;
public:
	MinHeap(int cap);
	int getParent(int i);
	int left(int i);
	int right(int i);
	void MinHeapify(int i);
	int extractMin();
	int getMin();
	void decreseKey(int i, int val);
	void deleteKey(int i);
	void insertKey(int key);
};

MinHeap::MinHeap(int cap) {
	capacity = cap;
	heapSize = 0;
	heapArray = new int[capacity];
}

void MinHeap::MinHeapify(int i) {
	int minimum = i;
	if(left(i) < heapSize && right(i) < heapSize) {
		minimum = min(heapArray[left(i)], heapArray[right(i)]) == heapArray[left(i)] ? left(i) : right(i);
	}
	//cout << minimum << endl;
	if(i != minimum) {
		swap(&heapArray[i], &heapArray[minimum]);
		MinHeapify(minimum);
	}
}

void MinHeap::deleteKey(int i) {
	if(i > heapSize- 1) {
		return;
	}else{
		decreseKey(i, INT_MIN);
		extractMin();
	}
}

void MinHeap::decreseKey(int i, int val) {
	if(i > heapSize) {
		cout << "Overflow";
		return;
	}
	heapArray[i] = val;
	while(i > 0 && heapArray[getParent(i)] > heapArray[i]) {
		swap(&heapArray[getParent(i)], &heapArray[i]);
		i = getParent(i);
	} 
}

int MinHeap::extractMin() {
	if(heapSize <= 0) {
		return -999;
	}
	if(heapSize == 1) {
		return heapArray[heapSize - 1];
	}
	int minKey = heapArray[0];
	swap(&heapArray[0], &heapArray[heapSize - 1]);
	heapSize--;
	MinHeapify(0);
	return minKey;
}



int MinHeap::getMin() {
	return heapArray[0];
}


int MinHeap::getParent(int i) {
	return (i - 1) / 2;
}

int MinHeap::left(int i) {
	return 2 * i + 1;
}

int MinHeap::right(int i) {
	return 2 * i + 2;
}

void MinHeap::insertKey(int key) {
	if(heapSize == capacity) {
		cout << "Overflow";
		return;
	}
	else {
		heapSize++;
		heapArray[heapSize - 1] = key;
		int i = heapSize - 1;
		while(i > 0 && heapArray[getParent(i)] > heapArray[i]) {
			swap(&heapArray[getParent(i)], &heapArray[i]);
			i = getParent(i);
		}
	}

}


int main() {
	MinHeap m(10);
	m.insertKey(10);
	m.insertKey(20);
	m.insertKey(30);
	m.insertKey(40);
	m.insertKey(50);
	m.insertKey(60);
	m.deleteKey(1);
	cout << m.heapArray[1];
}