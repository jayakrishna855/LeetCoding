class Solution {
    public long sumAndMultiply(int n) {
        long x =0, sum =0,value = 1;
        int i = 0;
        if(n == 0) return 0;
        while(n>0){
            int d = n%10;
            x = x + (long)Math.pow(10, i)*d;
            System.out.println(x);
            if(d!=0)i+=1;
            n/=10;
        }
        value= x;
        while(x>0){
            sum+=x%10;
            x=x/10;
        }
        return (value * sum);

    }
}