第一个只出现一次的字符

# 1 题目描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。

<br/>

# 2 思路
本题很容易想到用一个容器暂存字符出现的次数，但是用 HashMap 这样的容器（如解法一）在某些情况下的时间复杂度并不是线性的，因为 HashMap 的 get 方法的时间复杂度取决于冲突个数。

真正的线性时间复杂度的解法可以通过定义一个哈希表来实现（如解法二），用数组存放每个元素的 ASCII 码。

<br/>

# 3 代码实现
## 解法一：
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

## 解法二：
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