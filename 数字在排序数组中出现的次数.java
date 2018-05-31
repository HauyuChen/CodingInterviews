数字在排序数组中出现的次数


# 1 题目描述 #
---

统计一个数字在排序数组中出现的次数。

<br/>

# 2 思路 #
---

通过二分查找分别找出数字在排序数组中第一次出现的位置和最后一次出现的位置。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0){
            return 0;
        }
        int indexFirst = getFirst(array,0,array.length-1,k);
        int indexLast = getLast(array,0,array.length-1,k);
        if(indexFirst!=-1 && indexLast!=-1){
            return indexLast-indexFirst+1;
        }
        return 0;
    }
    
    private int getFirst(int[] array,int start,int end,int k){
        while(start<=end){
            int mid = ((end-start)>>1)+start;
            if(array[mid]<k){
                start = mid+1;
            }
            else if(array[mid]>k){
                end = mid-1;
            }
            else{
                if(mid!=0&&array[mid-1]!=k || mid==0){
                    return mid;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    
    private int getLast(int[] array,int start,int end,int k){
        while(start<=end){
            int mid = ((end-start)>>1)+start;
            if(array[mid]<k){
                start = mid+1;
            }
            else if(array[mid]>k){
                end = mid-1;
            }
            else{
                if(mid!=array.length-1&&array[mid+1]!=k || mid==array.length-1){
                    return mid;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
```

<br/>