import java.util.*;
import java.io.*;
import java.math.*;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MAX_VALUE;
	private static Scanner in=new Scanner(System.in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static long MaxPath(long left,long right){
		if(left>right)return left;
		else return right;
	}
	
	public static long MaxPath(int ar[][],int level,int index,int n){
		if(level>=n){
			return 0;
		}
		long left=ar[level][index]+MaxPath(ar,level+1,index,n);
		long right=ar[level][index]+MaxPath(ar,level+1,index+1,n);
		return MaxPath(left, right);
	}
 
	public static void main(String[] args) throws IOException {	
		int t=in.nextInt();
		int n,ar[][];
		for(int k=0;k<t;k++){
			n=in.nextInt();
			ar=new int[n][n];
			int count=1;
			for(int i=0;i<n;i++){
				for(int j=0;j<count;j++){
					ar[i][j]=in.nextInt();
				}
				count++;
			}
			System.out.println(MaxPath(ar,0,0,n));
		}
	}
}
