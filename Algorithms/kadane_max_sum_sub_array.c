int maxSubArray(const int* A, int n1) {
    int i,max_global=A[0],max_current=A[0];
    for(i=1;i<n1;i++){
        max_current = max(A[i],A[i]+max_current);
        if(max_global<max_current){
            max_global = max_current;
        }
    }
    
    return max_global;
    //printf("%d",largest);
}

int max(int a, int b){
    int m = a>b?a:b;
    return m;
}

int main() {
    int a[6]  = {4, -1, -2, 5, 3, -7};
    printf("%d",maxSubArray(a, 6));
}

