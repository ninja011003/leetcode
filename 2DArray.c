#include <stdio.h>
#include <stdlib.h>
int** ArrayExtracter(int** OriginalArr,int OriRows,int OriCols,int x,int y,int rows,int cols){
    int** Arr = (int**)malloc(rows * sizeof(int*));
    for (int i = 0; i < rows; i++) {
        Arr[i] = (int*)malloc(cols * sizeof(int));
    }
    if(x+rows>OriRows||y+cols>OriCols){
        printf("INVALID PARAMETERS!!\n");
        return NULL;
    }
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            Arr[i][j]=OriginalArr[x+i][y+j];
        }
    }
    return Arr;
}
void ArrayPrinter(int** Arr,int rows,int cols){
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            printf("%d ",Arr[i][j]);
        }
        printf("\n");
    }
}
void main(){
    int rows,cols;
    printf("Enter the dimension of the Array(m,n): ");
    scanf("%d %d",&rows,&cols);
    int** Arr = (int**)malloc(rows * sizeof(int*));
    for (int i = 0; i < rows; i++) {
        Arr[i] = (int*)malloc(cols * sizeof(int));
    }
    printf("Enter the elements:-\n");
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            scanf("%d",&Arr[i][j]);
        }
    }
    printf("enter the vertex of Extraction(x,y): ");
    int x,y,NewRows,NewCols;
    scanf("%d %d",&x,&y);
    printf("enter the desired length of new Arr(rows,columns): ");
    scanf("%d %d",&NewRows,&NewCols);
    printf("\n\nAnswer:-\nOriginal Array:-\n");
    ArrayPrinter(Arr,rows,cols);
    printf("Extracted Array:-\n");
    int** NewArr=ArrayExtracter(Arr,rows,cols,x,y,NewRows,NewCols);
    ArrayPrinter(NewArr,NewRows,NewCols);
}