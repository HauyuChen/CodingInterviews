�����е�·��

# 1 ��Ŀ����
---
�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�


<br/>

# 2 ˼·
---
��������û��ݷ��������Ŀ�������ӣ�������Ӧ��ע��ϸ�ڣ����������±꣬���ʱ�־��
1. �ݹ�Ľ��������� str �����Ѿ�ȫ���Ƚ���ϣ�����ܱȽϵ� str �����˵�����ڸ�·�������� true��
2. ÿ�εݹ�ǰ���ж��Ƿ�������������ʷ�Χ�������� && matrix ����� str �����Ӧ��λ�õ��ַ���� && ��λ��֮ǰδ�߹�����
3. ÿ���ж����������ĸ������Ƿ���ϣ������ϣ��ֱ�ȥ�ĸ������ж� str[pos+1] �Ƿ��ܳ��������������ϣ�visted[pos] ������ 0 ��


<br/>

# 3 ����ʵ�֣�Java��

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