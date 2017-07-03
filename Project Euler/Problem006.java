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
            int n=in.nextInt();
		long sum=0;
		long squaresum=0;
		for(int i=1;i<=n;i++){
			sum=sum+i;
			squaresum=(long) (squaresum+Math.pow(i, 2));
		}
		
		System.out.println((long)Math.pow(sum,2)-squaresum);
        }
    }
}
