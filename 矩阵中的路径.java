矩阵中的路径

# 1 题目描述
---
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。


<br/>

# 2 思路
---
本题可以用回溯法解决，题目本身不复杂，但尤其应该注意细节，比如数组下标，访问标志。
1. 递归的结束条件是 str 数组已经全部比较完毕，如果能比较到 str 的最后，说明存在该路径，返回 true；
2. 每次递归前先判断是否符合条件（访问范围在数组内 && matrix 数组和 str 数组对应的位置的字符相等 && 该位置之前未走过）；
3. 每次判断上下左右四个方向是否符合，若符合，分别去四个方向判断 str[pos+1] 是否能成立；若都不符合，visted[pos] 重新置 0 ；


<br/>

# 3 代码实现（Java）

```
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || rows<1 || cols<1 || str==null){
            return false;
        }
        int[] visted = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            visted[i] = 0;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(findPath(matrix,rows,cols,i,j,str,0,visted)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[] matrix,int rows,int cols,int row,int col,char[] str,int index,int[] visted){
        if(index == str.length){
            return true;
        }
        boolean hasPath = false;
        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[index] && visted[row*cols+col]==0) {
            index++;
            visted[row*cols+col] = 1;

            hasPath = findPath(matrix,rows,cols,row-1,col,str,index,visted) ||
                    findPath(matrix,rows,cols,row+1,col,str,index,visted) ||
                    findPath(matrix,rows,cols,row,col-1,str,index,visted) ||
                    findPath(matrix,rows,cols,row,col+1,str,index,visted);

            if(!hasPath) {
                index--;
                visted[row*cols+col] = 0;
            }
        }
        return hasPath;
    }
}
```

<br/>