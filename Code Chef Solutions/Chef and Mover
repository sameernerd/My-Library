import java.util.*;
import java.io.*;
import java.math.*;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MIN_VALUE;
	private static Scanner in=new Scanner(System.in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 
	public static void solve(long ar[],int n,int d){
		long sum=0,count=0;
		for(int i=0;i<n;i++){
			sum=sum+ar[i];
		}
		for(int i=0;i<d;i++){
			for(int j=i;j<n;j+=d){
				if(ar[j]>sum/n){
					if(j+d<n){
						ar[j+d]=ar[j+d]+ar[j]-sum/n;
						count+=ar[j]-sum/n;
						ar[j]=sum/n;
					}
				}
				else if(ar[j]<sum/n){
					if(j+d<n){
						ar[j+d]=ar[j+d]+ar[j]-sum/n;
						count+=sum/n-ar[j];
						ar[j]=sum/n;
					}
				}
			}
		}
		int k;
		for(k=1;k<n;k++){
			if(ar[k]!=ar[k-1])break;
		}
		if(k!=n)System.out.println("-1");
		else System.out.println(count);
	}
 
	public static void main(String[] args) throws IOException {	
		int t=in.nextInt();
		int n,d;
		long ar[];
		for(int i=0;i<t;i++){
			n=in.nextInt();
			d=in.nextInt();
			ar=new long[n];
			for(int j=0;j<n;j++)
				ar[j]=in.nextLong();
			solve(ar,n,d);
		}
	}
} 
