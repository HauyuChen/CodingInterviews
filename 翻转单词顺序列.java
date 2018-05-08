翻转单词顺序列


# 1 题目描述 #
---

牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

<br/>

# 2 思路 #
---

先将整个字符串翻转，然后以空格分割成多个子字符串，再将子字符串逐一翻转。

当然，本题其实不需要这么复杂，直接分割原始字符串，然后从后往前拼接也是可以的。但第一种思路更具有通用性，可扩展性好。


<br/>

# 3 代码实现 #
---

```
public class Solution {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        
        str = reverse(str);
        String[] strs = str.split(" ");
        String retStr = "";
        for(int i=0;i<strs.length-1;i++){
            retStr = retStr + reverse(strs[i]) + " ";
        }
        retStr += reverse(strs[strs.length-1]);
        
        return retStr;
    }
    
    private String reverse(String str){
        String tmpStr = "";
        for(int i=str.length()-1;i>=0;i--){
            tmpStr += str.charAt(i);
        }
        return tmpStr;
    }
}
```

<br/>
