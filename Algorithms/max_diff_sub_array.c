#include<stdio.h>

int max_diff(int *arr,int length){
	int i,max_diff=arr[1]-arr[0],min_element=arr[0];
	for(i=1;i<length;i++){
		if(arr[i]-min_element>max_diff){
			max_diff = arr[i]-min_element;
		}
		if(min_element>arr[i]){
			min_element=arr[i];
		}
	}
	return max_diff;
}


int main(){
	int i,n;
	scanf("%d",&n);
	int *arr;
	arr = (int*)malloc(sizeof(int)*n);	
	for(i=0;i<n;i++){
		scanf("%d",arr+i);
	}
	printf("%d",max_diff(arr,n));

}