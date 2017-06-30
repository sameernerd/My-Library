import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;
        long n1,n2,n3;
        long sum;
        for(int k=0;k<t;k++){
            n=in.nextInt();
            sum=0;
            if(n%3!=0)n1=n/3;
            else n1=(n/3)-1;
            if(n%5!=0)n2=n/5;
            else n2=(n/5)-1;
            sum=sum+((n1*(3+n1*3))/2);
            sum=sum+((n2*(5+n2*5))/2);
            if(n>=15){
                if(n%15!=0)n3=n/15;
                else n3=(n/15)-1;
                sum=sum-((n3*(15+n3*15))/2);
                System.out.println(sum);
            }
            else System.out.println(sum);
        }
        
    }
}
