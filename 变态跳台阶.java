变态跳台阶


# 1 题目描述 #
---

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

<br/>

# 2 思路 #
---

假设：\
第一次跳1个台阶：f（n-1）种跳法；\
第一次跳2个台阶：f（n-2）种跳法；\
...\
第一次跳n-1个台阶：f（1）种跳法。

综上，
f(n) = f(n-1) + f(n-2) + ... + f(1)\
f(n-1) = f(n-2) + f(n-3) + ... + f(1)\

故，
f(n) = 2*f(n-1)

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
```

<br/>