#include<stdio.h>
#include<math.h>
int main()
{
      float a,b,c,d;
      printf("本金:");
      scanf("%f",&b);
      printf("利率:");
      scanf("%f",&c);
      printf("年限:");
      scanf("%f",&d);
      a=b*pow((1+c),d);
      printf("%f\n",a);
}