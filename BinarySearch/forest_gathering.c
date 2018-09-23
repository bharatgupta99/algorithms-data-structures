#include<stdlib.h>
#include<stdio.h>
#include<limits.h>

long long int calculateWoodGathered(long long int months, long long int* heights, long long int* rates, long long int N, long long int L, long long W) {
    long long int i;
    long long int totalWoodPossible = 0, temp;
    for(i = 0; i < N; i ++) {
        temp = heights[i] + rates[i] * months;
        if(temp >= L) {
            totalWoodPossible += temp;
            if(totalWoodPossible > W) break;
        }
    }
    return totalWoodPossible;
}

int main() {
    long long int N, L, W;

    scanf("%lld", &N);
    scanf("%lld", &W);
    scanf("%lld", &L);

    long long int* H = (long long int*)malloc(sizeof(long long int) * N);
    long long int* R = (long long int*)malloc(sizeof(long long int) * N);
    long long int i;

    for(i = 0; i < N; i ++) {
    	scanf("%lld", &H[i]);
    	scanf("%lld", &R[i]);
    }
   
    long long int l = 0, r = W;
    long long int mid;
    while(l <= r) {
        mid = (l + r) / 2;
	    long long int woodGathered = calculateWoodGathered(mid, H, R, N, L, W);
        if(woodGathered >= W) {
            r = mid - 1;
        }else {
            l = mid + 1;
        }          
    }
    printf("%lld\n", l);

}






