用两个栈实现队列

# 1 题目描述
---

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

<br/>

# 2 思路
---

1. 入队操作：入队前要先把 stack2 的元素全部放回 stack1 ，直到 stack2 为空，才把元素压入 stack1 ；
2. 出队操作：出队前先判断 stack2 是否为空，如果不为空就直接返回 stack2 的栈顶即可；如果为空，则先将 stack1 的元素全部压入 stack2 ，再返回 stack2 的栈顶元素。
注意：在这个过程中，要么 stack1 为空，要么 stack2 为空，不会出现 stack1 和 stack2 都为空的情形。

<br/>

# 3 代码实现（Java）
---

```
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }
    
    public int pop() {
        if(!stack2.empty()){
            return stack2.pop();
        }
        else{
            if(stack1.empty()){
                return -1;
            }
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
```

<br/>