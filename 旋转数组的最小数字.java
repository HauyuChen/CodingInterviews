��ת�������С����

# 1 ��Ŀ����
---
��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��

<br/>

# 2 ˼·
---
ͨ�����ֲ���ʵ�֣���Ҫ�������������

1. array[low] �� array[mid] �� array[high] ������ȣ���ʱֻ��˳�������
2. ��� array[low]<=array[mid] ,˵����СԪ�����Ұ�ߣ�
3. ��� array[high]>=array[mid] ,˵����СԪ�������ߣ�

<br/>

# 3 ����ʵ�֣�Java��
---

```
import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array==null){
            return 0;
        }
        int low = 0;
        int high = array.length-1;
        int mid = 0;

        while(array[low]>=array[high]){
            if(high-low==1){
                mid = high;
                break;
            }
            mid = ((high-low)>>1) + low;
            if(array[low]==array[mid]&&array[mid]==array[high]){
                int min = array[low];
                for(int i=low+1;i<=high;i++){
                    min = min<array[i]?min:array[i];
                }
                return min;
            }
            if(array[mid]>=array[low]){
                low = mid;
            }
            else if(array[mid]<=array[high]){
                high = mid;
            }
        }
        return array[mid];
    }
}
```

<br/>