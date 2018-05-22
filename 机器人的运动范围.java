机器人的运动范围


# 1 题目描述 #
---

地上有一个 m 行和 n 列的方格。一个机器人从坐标 0,0 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。 

例如，当 k 为 18 时，机器人能够进入方格（35,37），因为 3+5+3+7 = 18 。但是，它不能进入方格（35,38），因为 3+5+3+8 = 19 。请问该机器人能够达到多少个格子？

<br/>

# 2 思路 #
---

可把题意理解为机器人在 m*n 的矩阵上移动。判断能不能进入一个坐标的条件是该坐标在矩阵范围内且坐标的数位之和不大于 k 。

通过一个访问标志数组记录机器人走过的位置，初始全为 0 ，机器人每走过一个坐标，相应位置 1 。如此一来，当机器人走入一个坐标，count + 1，然后分别向上下左右四个方向回溯，把四个方向的计数相加即为机器人能达到的所有范围。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0 || rows<0 || cols<0){
            return 0;
        }
        int[] isVisited = new int[rows*cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                isVisited[row*cols+col] = 0;
            }
        }
        return movingCountCore(threshold,0,0,rows,cols,isVisited);
    }
    
    private int movingCountCore(int k,int row,int col,int rows,int cols,int[] isVisited){

       if(row>=0&&row<rows && col>=0&&col<cols && isVisited[row*cols+col]!=1 && getSum(row)+getSum(col)<=k){
           isVisited[row*cols+col] = 1;
           return 1 + movingCountCore(k,row+1,col,rows,cols,isVisited)
                   + movingCountCore(k,row-1,col,rows,cols,isVisited)
                   + movingCountCore(k,row,col+1,rows,cols,isVisited)
                   + movingCountCore(k,row,col-1,rows,cols,isVisited);
       }
       else{
           return 0;
       }
   }

   private int getSum(int num){
       int sum = 0;
       while(num>0){
           sum += num%10;
           num /= 10;
       }
       return sum;
   }
    
    
}

```

<br/>
