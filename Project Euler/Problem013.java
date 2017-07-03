import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
   

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String temp;
        BigInteger sum=new BigInteger("0");
        BigInteger t;
        for(int i=0;i<n;i++){
            temp=in.next();
            t=new BigInteger(temp);
            sum=sum.add(t);
        }   
        System.out.println(sum.toString().substring(0,10));
    }
}
