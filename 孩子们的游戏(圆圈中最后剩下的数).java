孩子们的游戏(圆圈中最后剩下的数)


# 1 题目描述 #
---

每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

<br/>

# 2 思路 #
---

本题实质上是约瑟夫环问题。可以通过模拟环形数据结构来实现，一种方法是采用循环链表，另一种方法是采用数组，当下标处于数组中最后一个元素时，下一步应该回到数组第一个元素。

本题还有时间复杂度为 O(n) 的解法（如解法二）。

<br/>

# 3 代码实现 #
---

## 解法一： ##

```
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        
        int people = n;
        int index = -1;
        int step = 0;
        int[] arr = new int[n];
        
        while(people>0){
            index++;
            if(index==n){
                index = 0;
            }
            if(arr[index]==-1){
                continue;
            }
            step++;
            if(step == m){
                arr[index] = -1;
                step = 0;
                people--;
            }
        }
        
        return index;
    }
}
```

## 解法二： ##

```
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        
        int ret = 0;
        for(int i=2;i<=n;i++){
            ret = (ret+m)%i;
        }
        return ret;
    }
}
```

<br/>