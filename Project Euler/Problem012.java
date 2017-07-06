import java.io.*;
import java.util.*;

public class Solution {
    
    public static int Divisors(int num){
        int count=0,divisors=1,c=2;
        while(num!=1){
            while(num%c==0){
                num=num/c;
                count++;
            }
            divisors=divisors*(count+1);
            count=0;c++;
        }
        return divisors-1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int ar[]=new int[45001];
        ar[0]=0;
        int num;
        for(int i=1;i<=45000;i++){
            num=i*(i+1)/2;
            ar[i]=Divisors(num);
        }
        for(int k=0;k<t;k++){
            int n=in.nextInt();
            for(int i=0;i<ar.length;i++){
                if(ar[i]>=n){
                    System.out.println(i*(i+1)/2);
                    break;
                }
            }
           
        }
    }
}
