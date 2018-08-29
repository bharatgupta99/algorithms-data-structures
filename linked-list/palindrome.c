#include<stdio.h>

struct node{
	int data;
	struct node *next;
}

struct node* head=NULL;

void palindromeCheck(struct node *h){
	if(h==NULL) return 1;
	else{
		int y = palindromeCheck(h->next);
		if(y==1){
			if(h->data == head->data){
				head = head->next;
			}
			if(head = h){
				return 2;
			}
		}
		if(y==2){
			return 2;
		}
		return 0;
	}
}

int main(){


}