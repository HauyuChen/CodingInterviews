数值的整数次方


# 1 题目描述 #
---

给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent 。求 base 的 exponent 次方。

<br/>

# 2 思路 #
---

本题要求根据 base、exponent 求 base 的 exponent 次幂。注意考虑几种情形：

1. base 为 0 ；
2. exponent为负或 0 。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public double Power(double base, int exponent) {
        if(base==0 && exponent<0){
            return 0.0;
        }
        int flag = 0;
        double ret = 1.0;
        
        if(exponent<0){
            exponent = 0-exponent;
            flag = 1;
        }
        for(int i=0;i<exponent;i++){
            ret *= base;
        }
        
        if(flag==1){
            return 1.0/ret;
        }
        return ret;
  }
}
```

<br/>
