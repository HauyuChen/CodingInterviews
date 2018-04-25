������ջʵ�ֶ���

# 1 ��Ŀ����
---

������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�

<br/>

# 2 ˼·
---

1. ��Ӳ��������ǰҪ�Ȱ� stack2 ��Ԫ��ȫ���Ż� stack1 ��ֱ�� stack2 Ϊ�գ��Ű�Ԫ��ѹ�� stack1 ��
2. ���Ӳ���������ǰ���ж� stack2 �Ƿ�Ϊ�գ������Ϊ�վ�ֱ�ӷ��� stack2 ��ջ�����ɣ����Ϊ�գ����Ƚ� stack1 ��Ԫ��ȫ��ѹ�� stack2 ���ٷ��� stack2 ��ջ��Ԫ�ء�
ע�⣺����������У�Ҫô stack1 Ϊ�գ�Ҫô stack2 Ϊ�գ�������� stack1 �� stack2 ��Ϊ�յ����Ρ�

<br/>

# 3 ����ʵ�֣�Java��
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