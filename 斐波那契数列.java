쳲���������


��Ŀ����
��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
n<=39


˼·��
�������õݹ�ⷨ������Ľⷨʱ�临�Ӷ�ΪO(n)��

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