��һ��ֻ����һ�ε��ַ�

# 1 ��Ŀ����
��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ�á�

<br/>

# 2 ˼·
����������뵽��һ�������ݴ��ַ����ֵĴ����������� HashMap ��������������ⷨһ����ĳЩ����µ�ʱ�临�ӶȲ��������Եģ���Ϊ HashMap �� get ������ʱ�临�Ӷ�ȡ���ڳ�ͻ������

����������ʱ�临�ӶȵĽⷨ����ͨ������һ����ϣ����ʵ�֣���ⷨ��������������ÿ��Ԫ�ص� ASCII �롣

<br/>

# 3 ����ʵ��
## �ⷨһ��
```
import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null){
            return -1;
        }
        
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else{
                hm.replace(ch,hm.get(ch)+1);
            }
        }
        for(int i=0;i<str.length();i++){
            if(hm.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
```

## �ⷨ����
```
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null){
            return -1;
        }
        
        int[] hashTable = new int[256];
        for(int i=0;i<256;i++){
            hashTable[i] = 0;
        }
        for(int i=0;i<str.length();i++){
            hashTable[str.charAt(i)]++;
        }

        for(int i=0;i<str.length();i++){
            if(hashTable[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
```

<br/>