数组中的逆序对


# 1 题目描述 #
---

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数 P 。并将 P 对 1000000007 取模的结果输出，即输出 P%1000000007 。

<br/>

# 2 思路 #
---

看到这道题的时候，第一个想到两个 for 循环，毫不意外的超时了。

合理方案是利用归并排序来解决，大体思路为：把原数组分为两个子数组，统计两个子数组内部的逆序对个数，再统计两个子数组之间的逆序对个数，相加得结果。

统计两个子数组内部的逆序对个数性质和原问题一样，用递归。

统计两个子数组间的逆序对个数时，归并排序就派上用场了，在进行归并排序的时候顺便判断逆序对个数，比如第一个子数组的最后一个元素 X 大于第二个子数组的最后一个元素，说明 X 可以和第二个子数组的所有元素构成逆序对；否则，移动第一个子数组的指针，判断前一个元素；如果第一个子数组的最后一个元素 X 大于第二个子数组的最后一个元素，移动第二个子数组的指针，判断前一个元素；以此类推。

注：这题还应该注意 count 太大的情况，记得对 1000000007 取模。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public int InversePairs(int [] array) {
        if(array==null || array.length<2){
            return 0;
        }
        int[] tmp = new int[array.length];
        for(int i=0;i<array.length;i++){
            tmp[i] = array[i];
        }
        return InversePairsCore(array,tmp,0,array.length-1);
    }
    
    private int InversePairsCore(int[] array,int[] tmp,int start,int end){
        if(end==start){
            tmp[start] = array[start];
            return 0;
        }
        int mid = ((end-start)>>1)+start;
        int countLeft = InversePairsCore(tmp,array,start,mid)%1000000007;
        int countRight = InversePairsCore(tmp,array,mid+1,end)%1000000007;
        int start1 = start;
        int start2 = mid+1;
        int end1 = mid;
        int end2 = end;
        int index = end;
        int count = 0;
        
        while(end1>=start1 && end2>=start2){
            if(array[end1]>array[end2]){
                if(count>=1000000007){
                    count = count%1000000007;
                }
                count += end2-start2+1;
                tmp[index--] = array[end1--];
            }else{
                tmp[index--] = array[end2--];
            }
        }
        while(end1>=start1){
            tmp[index--] = array[end1--];
        }
        while(end2>=start2){
            tmp[index--] = array[end2--];
        }
        return (count + countLeft + countRight)%1000000007;
    }
}
```

<br/>