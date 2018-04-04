斐波那契数列


题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39


思路：
尽量不用递归解法，下面的解法时间复杂度为O(n)。

public class Solution {
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        int ret = 0;
        
        for(int i=2;i<=n;i++){
            ret = f1+f2;
            f1 = f2;
            f2 = ret;
        }
        
        return ret;
    }
}