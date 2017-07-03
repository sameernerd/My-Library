import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int[] SieveOfErathosthenes(){
        int n=1000000;
        int ar[]=new int[n+1];
        ar[0]=0;ar[1]=1;
		int c=2;
        for(int i=2;i<=n;i++)
            ar[i]=i;
		while(c*c<=n){
			if(ar[c]!=-1){
		for(int i=2*c;i<=n;i+=c){
			if(ar[i]==-1)continue;
			if(i!=c&&ar[i]%c==0)ar[i]=-1;
		}
		}
		c++;
	}
        return ar;
  }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int ar[]=SieveOfErathosthenes();
        long sum_ar[]=new long[1000000+1];
        sum_ar[0]=0;sum_ar[1]=1;
        long sum=0;
        for(int i=2;i<=1000000;i++){
                if(ar[i]!=-1){sum_ar[i]=sum+ar[i];sum=sum_ar[i];}
                else sum_ar[i]=sum;
               
        }
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(sum_ar[n]);
         }
      } 
  }
