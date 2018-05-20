和为S的两个数字


# 1 题目描述 #
---

输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

输出描述:

对应每个测试案例，输出两个数，小的先输出。

<br/>

# 2 思路 #
---

因为数组是有序的，所以可通过一前一后的方式求解符合要求的两个数，不需要暴力解决。

<br/>

# 3 代码实现 #
---

```
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array==null){
            return null;
        }
        ArrayList<Integer> retList = new ArrayList<Integer>();
        int start = 0;
        int end = array.length-1;
        int min = Integer.MAX_VALUE;
        
        while(start<end){
            int tmp = array[start]+array[end];
            if(tmp<sum){
                start++;
            }
            else if(tmp>sum){
                end--;
            }
            else{
                if(array[start]*array[end]<min){
                    min = array[start]*array[end];
                    retList.add(0,array[start]);
                    retList.add(1,array[end]);
                }
                start++;
            }
        }
        
        return retList;
    }
}
```

<br/>