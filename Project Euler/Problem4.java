import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String StringReverse(String str){
		StringBuffer strbuf=new StringBuffer(str);
		return strbuf.reverse().toString();
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int product;
		String str,rev;
		ArrayList<Integer> alpha=new ArrayList();
		for(int i=999;i>=100;i--){
			for(int j=i-1;j>=100;j--){
				product=i*j;
				
				str=""+product;
				rev=StringReverse(str);
				if(str.equals(rev)){
					alpha.add(product);
				}
			}
		}
		Collections.sort(alpha);
		
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            for(int i=alpha.size()-1;i>=0;i--){
                if(alpha.get(i)<n){
                    System.out.println(alpha.get(i));
                    break;
                }
            }
        }
    }
}
