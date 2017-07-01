import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int LCM(int n){
        int ar[]=new int[n+1];
            for(int i=0;i<=n;i++)
                ar[i]=i;
            long mult=1;
            int count=0;
            int max=0;
            for(int i=2;i<=n;i++){
                max=0;
                if(ar[i]==1)continue;
                for(int j=2;j<=n;j++){
                    count=1;
                    //System.out.print(ar[j]+" ");
                    while(ar[j]%i==0&&ar[j]!=0){
                         ar[j]=ar[j]/i;
                         count++;
                    }
                    if(count>max)max=count;
                }
                mult=mult*(int)Math.pow(i,max-1);
                
            }
            return mult;
    
    
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            LCM(n);
        }
    }
}
