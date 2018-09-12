#include<stdio.h>

int bs(int a[], int left, int right, int searchTerm) {
	if(right > left){
		int mid = (left + right) / 2;
		if(a[mid] == searchTerm) {
			return mid;
		}
		if(a[mid] < searchTerm){
			return bs(a, mid+1, right, searchTerm);
		}
		if(a[mid] > searchTerm){
			return bs(a, right, mid-1, searchTerm);
		}
	}
	return -1;
}

int main() {
	int array[] = {1, 2, 3, 4, 5, 6};
	int lengthOfArray = 6;
	int searchTerm = 9;
	printf("%d\n", bs(array, 0, lengthOfArray-1, searchTerm));
}

