#include<stdio.h>
#include<stdlib.h>

int* longestPalindromeCount(char *pattern, int lengthOfPattern) {

	int *temp = (int*)malloc(sizeof(int) * lengthOfPattern);
	int i, j = 0;
	temp[0] = 0;
	for( i = 1; i < lengthOfPattern;) {
		if( pattern[i] == pattern [j] ) {
			temp[i] = j+1;
			j ++;
			i ++;
		}
		else {
			if(j == 0) {
				temp[i] = 0;
				i ++;
			}else{
				j = temp[j - 1];
			}
		}

	}
	return temp;
}

int kmpSearch(char *text, char* pattern, int lengthOfText, int lengthOfPattern) {
	int *Z = longestPalindromeCount(pattern, lengthOfPattern);
	int i, j = 0;
	for( i = 0; i < lengthOfText;) {
		if ( text[i] == pattern [j]) {
			i ++;
			j ++;

		}
		else {
			if(j == 0) {
				i++;
			}else {
				j = Z[j - 1];
			}
		}
		if(j == lengthOfPattern) return i-j;
	}
	return -1;


}





int main() {
	int n1, n2;
	printf("enter length of text\n");
	scanf("%d", &n1);
	printf("enter length of pattern\n");
	scanf("%d", &n2);
	char *text = (char*)malloc(sizeof(char) * n1);
	char *pattern = (char*)malloc(sizeof(char) * n2);
	printf("Enter text\n");
	scanf("%s", text);
	printf("Enter pattern\n");
	scanf("%s", pattern);
	printf("%d\n", kmpSearch(text, pattern, n1, n2));

}