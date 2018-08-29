int* plusOne(int* A, int n1, int *len1) {
   int i,j;
   int *a=(int *)malloc(sizeof(int)*n1);
   a[0]=A[n1-1]+1;
    for(i=n1-1,j=0;i>0;i--,j++)
    {
     if(a[j]>=10)
     {
         a[j]=0;
         a[j+1]=A[i-1]+1;
     }
     else
     {
         a[j+1]=A[i-1];
     }
    }
    if(a[n1-1]>=10)
    {
        a[n1-1]=0;
        a=(int *)realloc(*a,sizeof(int)*(n1+1));
        a[n1]=1;
        n1=n1+1;
    }
    *len1=n1;
    int count=0,k=0;
    for(i=n1-1,j=0;i>=0;i--)
    {
        if(a[i]!=0)
        {
            k=1;
        }
        if(a[i]==0&&k==0)
        count++;
    }
    int *b=(int *)malloc(sizeof(int)*n1-count);
    *len1=n1-count;
    for(i=n1-1-count,j=0;i>=0;i--,j++)
    {
      b[j]=a[i];
    }
    return b;
    
}
