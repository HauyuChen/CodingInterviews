调整数组顺序使奇数位于偶数前面


# 1 题目描述 #
---

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

<br/>

# 2 思路 #
---

- 直接借用冒泡排序的算法实现的话，时间复杂度是 O(N^2) ；
- 如果借用辅助数组，时间复杂度可以降为 O(N) ，但需要额外空间。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0 && array[j+1]%2==1){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
```

<br/>
