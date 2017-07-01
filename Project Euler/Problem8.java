import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public void solve(int ar[],int n){
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
         int n,k,ar[];
         String str;
        long max,pro;
        for(int g=0;g<t;g++){
         n=in.nextInt();
         k=in.nextInt();
         str=in.next();
            ar=new int[n];
            for(int i=0;i<str.length();i++){
                ar[i]=((int)str.charAt(i)-48);
            }
         max=0;
         pro=1;
            int l=0;
        for(int i=0;(i+k)<ar.length;i++){
            while(l!=k){
                pro=pro*ar[i+l];
                l++;
            }
            if(pro>max){
                max=pro;
            }
            pro=1;
            l=0;
        }
        System.out.println(max);
        }
    }
}
