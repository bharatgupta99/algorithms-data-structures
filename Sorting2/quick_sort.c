#include<stdio.h>
void swap(int *A, int x, int y) {
	int temp = A[x];
	A[x] = A[y];
	A[y] = temp;
}

int partitionPivot( int *A, int start, int end ) {
	int partitionIndex = 0;
	int i, pivot = A[end];
	for( i = 0; i < end ; i ++) {
		if( pivot > A[i] ) {
			swap(A, partitionIndex, i);
			partitionIndex ++;
		}
	}
	swap(A, partitionIndex, end);
	return partitionIndex;
}


void quickSort(int *A, int start, int end) {
	if (start >= end) {
		return;
	}else {
		int res = partitionPivot(A, start, end);
		quickSort(A, start, res - 1 );
		quickSort(A, res + 1, end);
	}
}
	
int main() {
	int i, A[] = {4,1,3,9,7,5,0};
	quickSort(A, 0, 6);
	for( i = 0; i < 6; i ++) {
		printf("%d ", A[i] );
	}
}