栈的压入、弹出序列


# 1 题目描述 #
---

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

<br/>

# 2 思路 #
---

1. 如果 popA 当前元素等于 stack 栈顶元素，则 stack 栈顶出栈，继续考虑 popA 的下一元素；
2. 否则，若 pushA 当前元素不等于 popA 当前元素，则将 pushA 当前元素入栈；直到 pushA 当前元素等于 popA 当前元素；
3. pushA 当前元素等于 popA 当前元素，则继续考虑 popA 和 pushA 的下一元素。

注：

1. 这里我设置了一个哨兵 isMod ，若思路中的三个步骤都不符合，说明不是该压栈序列的弹出序列，提前结束，返回 false ；
2. 若最后 stack 非空，返回 false 。

<br/>

# 3 代码实现 #
---

```
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length){
            return false;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        boolean isMod = false;
        int indexOfPushA = 0;
        
        for(int i=0;i<popA.length;i++){
            isMod = false;
            if(!stack.empty() && popA[i]==stack.peek()){
                stack.pop();
                continue;
            }
            
            while(indexOfPushA!=pushA.length && popA[i]!=pushA[indexOfPushA]){
                stack.push(pushA[indexOfPushA]);
                indexOfPushA++;
                isMod = true;
            }
            if(indexOfPushA!=pushA.length && popA[i]==pushA[indexOfPushA]){
                indexOfPushA++;
                isMod = true;
            }
            
            if(isMod==false){
                return false;
            }
        }
                
        if(!stack.empty()){
            return false;
        }
        
        return true;
    }
}

```

<br/>