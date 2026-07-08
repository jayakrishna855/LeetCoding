class Solution {
    public long sumAndMultiply(int n) {
       long sum=0;
        int rem;
        int num=0;
        int place=1;
        while(n>0){
            rem=n%10;
            if(rem!=0){
                num=rem*place+num;
                place*=10;
                sum=sum+rem;

            }
            n=n/10;
        }
        return num*sum;

    }
}