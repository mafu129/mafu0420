#include<stdio.h>
#include<math.h>
int main()
{
      float a,b,c,d;
      printf("����:");
      scanf("%f",&b);
      printf("����:");
      scanf("%f",&c);
      printf("����:");
      scanf("%f",&d);
      a=b*pow((1+c),d);
      printf("%f\n",a);
}