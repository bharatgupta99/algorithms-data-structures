#include<stdio.h>

struct node{
	int data;
	struct node *next;
};

struct node *head = NULL;

void push(int d){
	if(head == NULL){
		struct node *newNode = (struct node*)malloc(sizeof(struct node));
		newNode->data = d;
		head = newNode;
		newNode->next = NULL;
	}else{
		struct node *temp = head;
		struct node *newNode = (struct node*)malloc(sizeof(struct node));
		newNode->data = d;
		while(temp->next){
			temp = temp->next;
		}
		temp->next = newNode;
		newNode->next = NULL;
	}
}

void pop(){
	if(head==NULL) printf("Link List Is Empty\n");
	else{
		struct node *temp = head;
		while(temp->next->next){
			temp = temp->next;
		}
		temp->next = NULL;
	}
}
int search(int data)
{
	struct node *current=head;
	while(current->next)
	{
		if(current->data==data)
		{
			return data;
		}
		current=current->next;
	}
	if(current->data==data)
		{
			return data;
		}
		else
	return 0;
	
}

int main(){
	push(10);
	push(20);
	push(30);
	pop();
	int e=search(20);
	if(e==0)
        {
    	printf("\nValue is absent");
	}
	else
	{
		printf("\n%d ",e);
	}
}
