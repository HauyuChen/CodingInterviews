数组中出现次数超过一半的数字


# 1 题目描述 #
---

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

<br/>

# 2 思路 #
---

看到这道题时想起了算法课讲到的查找最小 ｋ 的线性时间复杂度算法。如解法一，找到数组中出现次数过半的数，其实就是判断有序数组的中位数是否出现次数过半。有了这个前提，我们可以通过快速排序中的 Partition 来找到数组有序时的中位数，而不需要对数组排序，最后判断这个数出现的次数是否过半即可。

解法二用的是一种比较巧妙的思路，通过找到本题的规律求解。


<br/>

# 3 代码实现 #
---

## 解法一： ##

```
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null){
            return 0;
        }
        int mid = array.length/2;
        int start = 0;
        int end = array.length-1;
        int pivot = partition(array,start,end);
        
        while(pivot!=mid){
            if(pivot<mid){
                start = pivot+1;
                pivot = partition(array,start,end);
            }else{
                end = pivot-1;
                pivot = partition(array,start,end);
            }
        }
        
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[pivot]==array[i]){
                count++;
            }
        }
        
        return count>mid?array[pivot]:0;
    }
    
    private int partition(int[] array,int start,int end){
        int pivot = array[start];
        while(start<end){
            while(start<end && array[end]>=pivot){
                end--;
            }
            array[start] = array[end];
            while(start<end && array[start]<=pivot){
                start++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }
}
```

## 解法二： ##

```
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null){
            return 0;
        }
        
        int index = 0;
        int count = 1;
        for(int i=1;i<array.length;i++){
            if(count==0){
                index = i;
                count = 1;
            }
            if(array[index]==array[i]){
                count++;
            }
            else{
                count--;
            }
        }
        
        int times = 0;
        for(int i=0;i<array.length;i++){
            if(array[index]==array[i]){
                times++;
            }
        }

        return times>array.length/2?array[index]:0;
    }
}
```

<br/>
