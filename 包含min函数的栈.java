包含min函数的栈


# 1 题目描述 #
---

定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

<br/>

# 2 思路 #
---

通过一个辅助栈 minStack 来存放当前栈 dataStack 中的最小值。

如果新压入的元素比 minStack 的栈顶小，则压入新元素到 minStack ，否则将 minStack 的栈顶再次压入 minStack 。可见， dataStack 和 minStack 中元素的数量始终一致。

<br/>

# 3 代码实现 #
---

```
import java.util.Stack;

public class Solution {
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int node) {
        dataStack.push(node);
        if(minStack.empty() || minStack.peek()>node){
            minStack.push(node);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
```

<br/>