跳台阶


# 1 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

<br/>

# 2 思路
此题实质上是斐波那契序列问题。

<br/>

# 3 代码实现

```
public class Solution {
    public int JumpFloor(int target) {
        if(target<1){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        
        int f1 = 1;
        int f2 = 2;
        int ret = 0;
        
        for(int i=3;i<=target;i++){
            ret = f1 + f2;
            f1 = f2;
            f2 = ret;
        }
        
        return ret;
    }
}
```

<br/>