#include<stdio.h>
#include<stdlib.h>


void merge(int *X, int lengthOfX, int *Y, int lengthOfY, int *A, int lengthOfA) {
	int i = 0, j = 0, k = 0;
	while( i < lengthOfX && j < lengthOfY ) {
		if( X[i] <= Y[j] ) {
			A[k] = X[i];
			i ++;
		}
		else {
			A[k] = Y[j];
			j ++;
		}
		k ++;
	}
	while ( i < lengthOfX ) {
		A[k] = X[i];
		k ++;
		i ++;
	}
	while ( j < lengthOfY ) {
		A[k] = Y[j];
		k ++;
		j ++;
	} 
}

int mergeSort(int *A, int lengthOfA) {
	if(lengthOfA < 2) {
		return 0;
	}
	int i, j;
	int mid = lengthOfA / 2;
	int *X = (int*)malloc(sizeof(int) * mid);
	int *Y = (int*)malloc(sizeof(int) * lengthOfA - mid);
	for ( i = 0; i < mid; i ++ ) {
		X[ i ] = A[ i ];
	}
	for ( j = 0; j < lengthOfA; j ++) {
		Y[ j ] = A[ i + j ];
	}
	mergeSort(X, mid);
	mergeSort(Y, lengthOfA - mid);
	merge(X, mid, Y, lengthOfA - mid, A, lengthOfA);
	return 1;

}



int main() {
	int i, length;
	printf("enter length of array\n");
	scanf("%d", &length);
	printf("enter elements\n");
	int *A = (int*) malloc(sizeof(int) * length);
	for ( i = 0; i < length; i ++ ) {
		scanf( "%d", &A[i] );
	}
	mergeSort(A, length);
	printf("-----------------Result-----------------------------\n");
	for ( i = 0; i < length; i ++ ) {
		printf("%d\n", A[i]);
	}
}

















