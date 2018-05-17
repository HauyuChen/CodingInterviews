二维数组中的查找


# 1 题目描述 #
---

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

<br/>

# 2 思路 #
---

1. 每次从右上角开始匹配，若相等则返回 true ；
2. 若大于目标值，则删除最右列；
3. 若小于目标值，则删除最上行；
4. 直到超出数组范围。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array==null){
            return false;
        }
        
        int rows = array.length;
        int cols = array[0].length;
        int r = 0;
        int c = cols-1;
        
        while(r<rows&&c>=0){
            if(array[r][c]==target){
                return true;
            }else if(array[r][c]>target){
                c--;
            }else{
                r++;
            }
        }
        
        return false;
    }
}
```

<br/>