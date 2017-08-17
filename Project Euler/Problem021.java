import java.util.*;
import java.io.*;
import java.math.*;

import Library.BinaryTree;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MAX_VALUE;
	private static Scanner in=new Scanner(System.in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void Solve(int n,int q){
	}
 
	public static void main(String[] args) throws IOException {	
		HashMap<Long,Long> hash=new HashMap<Long, Long>();
		long sum;
		for(long i=2;i<=100000;i++){
			sum=0;
			for(int j=2;j<Math.sqrt(i);j++){
				if(i%j==0){
					 sum=sum+j+i/j;
					}
				}
			hash.put(i,sum+1);
		}
		int t=in.nextInt(),n;
		long val1,val2;
		for(int i=0;i<t;i++){
			n=in.nextInt();
			sum=0;
			for(long j=2;j<n;j++){
				val1=hash.get(j);
				if(hash.containsKey(val1)){
					val2=hash.get(val1);
					if(val2==j&&val1!=val2){
						sum=sum+j;
					}
				}
			}
			System.out.println(sum);
		}
	}
}
