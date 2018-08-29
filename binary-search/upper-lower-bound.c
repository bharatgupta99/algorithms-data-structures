#include<stdio.h>


int lower_bound(int *arr, int num,int length){
	int mid,result=-1;
	int l=0,r=length-1;
	while(l<=r){
		mid = (l+r)/2;
		if(arr[mid] == num){
			result = mid;
			r = mid-1;
		}
		if(arr[mid]<num){
			l = mid+1;
		}
		if(arr[mid]>num){
			r=mid-1;
		}
	}
	return result;

}
int upper_bound(int *arr, int num, int length){
	int mid,result=-1;
	int l=0,r=length-1;
	while(l<=r){
		mid=(l+r)/2;
		if(arr[mid]==num){
			result=mid;
			l = mid+1;
		}
		if(arr[mid]<num){
			l=mid+1;
		}
		if(arr[mid]>num)
			r=mid-1;	
	}
	return result;

}

int main(){
	int n,i,num;
	printf("Enter length of array\n");
	scanf("%d",&n);
	int *arr = (int*)malloc(sizeof(int)*n);
	printf("Enter elements\n");
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	printf("Enter element to find upper bound and lower bound\n");
	scanf("%d",&num);
	printf("Lower Bound = %d\n",lower_bound(arr,num,n));
	printf("Upper Bound = %d\n",upper_bound(arr,num,n));
}