旋转数组的最小数字

# 1 题目描述
---
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

<br/>

# 2 思路
---
通过二分查找实现，主要考虑三种情况：

1. array[low] 、 array[mid] 、 array[high] 三者相等，此时只能顺序遍历；
2. 如果 array[low]<=array[mid] ,说明最小元素在右半边；
3. 如果 array[high]>=array[mid] ,说明最小元素在左半边；

<br/>

# 3 代码实现（Java）
---

```
import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null){
            return 0;
        }
        int low = 0;
        int high = array.length-1;
        int mid = 0;

        while(array[low]>=array[high]){
            if(high-low==1){
                mid = high;
                break;
            }
            mid = ((high-low)>>1) + low;
            if(array[low]==array[mid]&&array[mid]==array[high]){
                int min = array[low];
                for(int i=low+1;i<=high;i++){
                    min = min<array[i]?min:array[i];
                }
                return min;
            }
            if(array[mid]>=array[low]){
                low = mid;
            }
            else if(array[mid]<=array[high]){
                high = mid;
            }
        }
        return array[mid];
    }
}
```

<br/>