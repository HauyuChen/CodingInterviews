和为S的连续正数序列


# 1 题目描述 #
---

小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出描述:

输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

<br/>

# 2 思路 #
---

本题应该利用有序的性质，设置两个坐标分别表示子序列的开始和结尾，每次匹配该子序列是否和为 sum 。

1. 如果是，则将子序列加入结果集；
2. 若和小于 sum ，则 end 加 1 ；
3. 若和大于 sum ，则 start 加 1 ；
4. 直到 start 小于 sum 的一半，则结束。（因为此时 start 加上后面的数字必定大于 sum ）。


<br/>

# 3 代码实现 #
---

```
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        if(sum<=2){
            return retList;
        }
        
        int start = 1;
        int end = 2;
        
        while(start<((1+sum)>>1)){
            int count = 0;
            for(int i=start;i<=end;i++){
                count += i;
            }
            if(count<sum){
                end++;
            }
            else if(count>sum){
                start++;
            }
            else{
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                for(int i=start;i<=end;i++){
                    tmpList.add(i);
                }
                retList.add(tmpList);
                start++;
            }
        }
              
        return retList;
    }
}
```

<br/>