#include<iostream>
using namespace std;

class Stack {
private:
	int top;
	int a[1000];

public:
	Stack(){top = -1;};
	int isEmpty();
	int isFull();
	int peek();
	void push(int d);
	int pop();
};

int Stack :: isEmpty() {
	return top == -1;
}

int Stack :: isFull() {
	return top == 999;
}

int Stack :: peek() {
	if(isEmpty())
		return -999;
	return a[top];
}

void Stack :: push(int d) {
	if(isFull()) {
		cout << "Stack is Full\n";
	}else{
		top ++;
		a[top] = d;
	}
}

int Stack :: pop() {
	if(isEmpty()) {
		cout << "Stack is Empty\n";
		return -999;
	}else{
		int temp = a[top];
		top --;
		return temp;
	}
}


int main() {

	Stack s;

	cout << s.pop() << endl;

}

