import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            long generate=0;
            boolean flag=false;
            int max=0;
           for(int a=3,b,c;a<=n/3;a++ ){
                b=((n*n-2*n*a)/(2*n-2*a));
                c=n-a-b;
                if(a*a+b*b==c*c){
                    if(a+b+c==n&&a*b*c>max){
                        max=a*b*c;
                        flag=true;
                    }   
                }
            }
            if(!flag)System.out.println("-1");
            else System.out.println(max);
        }
    }
}
