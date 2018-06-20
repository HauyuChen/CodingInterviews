字符串的排列


# 1 题目描述 #
---

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc ,则打印出由字符 a,b,c 所能排列出来的所有字符串 abc,acb,bac,bca,cab 和 cba。

输入描述:

输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

<br/>

# 2 思路 #
---

这是一道全排列的题，全排列的核心在 for 循环部分的代码，for 循环是从头开始遍历，对于每一个字符，对其后面的序列递归全排列。为了不影响其它排列，用两个 swap 来恢复。也就是说，先求所有可能出现在第一个位置的字符，然后第一个字符固定后，求后面所有字符的全排列。


<br/>

# 3 代码实现 #
---

```
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> retList = new ArrayList<String>();
        if(str==null || str.length()==0){
            return retList;
        }
        TreeSet<String> tmpSet = new TreeSet<String>();
        char[] chars = str.toCharArray();
        permutationCore(chars,0,tmpSet);
        retList.addAll(tmpSet);
        return retList;
    }
    
    private void permutationCore(char[] chars,int index,TreeSet<String> tmpSet){
        if(chars==null || chars.length==0 || index<0 || index>=chars.length){
            return ;
        }
        if(index == chars.length-1){
            tmpSet.add(String.valueOf(chars));
        }
        else{
            for(int i=index;i<chars.length;i++){
                swap(chars,index,i);
                permutationCore(chars,index+1,tmpSet);
                swap(chars,index,i);
            }
        }
    }
    
    private void swap(char[] chars,int m,int n){
        char ch = chars[m];
        chars[m] = chars[n];
        chars[n] = ch;
    }
}
```

<br/>
