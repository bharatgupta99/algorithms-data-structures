#include<stdio.h>
int main ()
{
int a,b,c;
scanf("%d%d%d",&a,&b,&c);
int d=((a>>31)|(!(!a)));
d=!(!d);
int e=(d*b)|((!d)*c);
printf("%d",e);
}
