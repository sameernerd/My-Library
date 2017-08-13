import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 class meramainmahan {
	
	public static void solve(long n,long b){
		long temp_n=n-b;
		long len=2*b;
		long divide_result=(long) Math.ceil((double)temp_n/len);
		//System.out.println(divide_result);
		long a=(1+(divide_result-1)*b)*divide_result;
		//System.out.println(a);
		long pos=n-(len*(divide_result-1)+b);
		//System.out.println(pos);
		long result=a+(pos-1)*divide_result;
		System.out.println(result);
	}
 
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		long n,b;
		for(int i=0;i<t;i++){
			n=in.nextLong();
			b=in.nextLong();
			solve(n,b);
		}
	}
 
}
 
