import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static private int MAX=90;
    
    public static long[] solveFibo(long [] ar){
        ar[0]=0;ar[1]=1;
        for(int i=2;i<=MAX;i++){
            ar[i]=ar[i-1]+ar[i-2];
        }
        return ar;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long ar[]=new long[MAX+1];
        solveFibo(ar);
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum=0;
            for(int i=0;i<=MAX;i++){
                if(ar[i]>n)break;
                if(ar[i]%2==0){
                    sum=sum+ar[i];
                }
            }
            System.out.println(sum);
        }
    }
}
