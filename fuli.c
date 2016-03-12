//F=P*(1+i)^N
//F=A((1+i)^N-1)/i
//I=P*i*N
#include<stdio.h>
#include<math.h>
int main()
{
double F,P,i,I;//F:复利终值 P:本金 i:利率 I:利息
int N;//利率获取时间的整数倍
int M;//复利次数
int a;
printf("1.本金求复利终值  2.复利终值求本金\n");
scanf("%d",&a);
if(a==1){
printf("本金:");
scanf("%lf",&P);
printf("年利率(%%):");
scanf("%lf",&i);
printf("存入年限:");
scanf("%d",&N);
printf("年复利次数:");
scanf("%d",&M);
if(M==1)
{
F=P*pow(1+i*0.01,N);
}
else
{
F=P*pow(1+i/M*0.01,M*N);
}
I=P*i*0.01*N;
printf("复利终值:%lf\n",F);
printf("如按单利计算，本息为:%lf\n",I);
}
if(a==2){
printf("复利终值:");
scanf("%lf",&F);
printf("年利率(%%):");
scanf("%lf",&i);
printf("存入年限:");
scanf("%d",&N);
printf("年复利次数:");
scanf("%d",&M);
if(M==1)
{
P=F/pow(1+i*0.01,N);
}
else
{
P=F/pow(1+i/M*0.01,M*N);
}
printf("本金:%lf\n",P);
}
}