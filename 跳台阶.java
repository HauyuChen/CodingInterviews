��̨��


# 1 ��Ŀ����
һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������

<br/>

# 2 ˼·
����ʵ������쳲������������⡣

<br/>

# 3 ����ʵ��

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