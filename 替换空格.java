替换空格


# 1 题目描述 #
---

请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为 We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。

<br/>

# 2 代码实现 #
---

```
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	String s = str.toString();
        String ret = "";
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                ret += "%20";
            }else{
                ret += s.charAt(i);
            }
        }
        
        return ret;
    }
}
```

<br/>