#include <stdio.h>
#include <string.h>
#include <math.h>
int decToBinary(int num, int start, int end)
{
    int len = (int)log2(num) + 1;
    int bit_arr[len];
    int new_num = 0;
    if (start < 0 || end >= len)
    {
        printf("invalid arguements\n");
        return -1;
    }
    //binary number computation
    for (int i = 0; i <len; i++)
    {
        bit_arr[len-i-1] = num % 2;
        num /= 2;
    }
    printf("\nANSWER:-\n");
    printf("Actual BinNum: ");
    for(int i=0;i<len;i++){
        printf("%d",bit_arr[i]);
    }
    printf("\nExtracted BinNum: ");
    int k=end-start;
    for(int i=start;i<=end;i++){
        printf("%d", bit_arr[i]);
        new_num += bit_arr[i] * (int)pow(2,k--);
    }
    printf("\n");
    return new_num;
}

int main()
{
    int num, i, j;
    printf("Enter an integer: ");
    scanf("%d", &num);
    printf("Enter the bitDigit to extract(i,j): ");
    scanf("%d %d", &i, &j);
    int n = decToBinary(num, i, j);
    printf("The Extracted num : %d", n);
    return 0;
}
