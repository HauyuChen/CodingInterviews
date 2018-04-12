连续子数组的最大和

# 1 题目描述
---
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)

<br/>

# 2 思路
---
本题应该想到线性时间复杂度的方案。

值得注意的还有对异常输入的判断，这里用了一个全局变量表示是否异常输入，因为合法的输入也可能返回的是 0 。


<br/>

# 3 代码实现（Java）
---
```
public class Solution {
    boolean badInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null){
            badInput = true;
            return 0;
        }
        int max = array[0];
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
            max = max>sum?max:sum;
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
```

<br/>