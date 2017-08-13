import java.util.*;
import java.io.*;
import java.math.*;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MIN_VALUE;
	private static Scanner in=new Scanner(System.in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 
	public static void solve(int n,int m,long mins[],long off[],int jobs[],String qual[]){
		long total=0;
		int opt,count=0;
		ArrayList<Integer> s=new ArrayList();
		for(int i=0;i<n;i++){
			opt=-1;
			for(int j=0;j<m;j++){
				if(qual[i].charAt(j)==49&&off[j]>=mins[i]&&jobs[j]>0){
					mins[i]=off[j];
					opt=j;
				}
			}
			if(opt!=-1){
				if(!s.contains(opt))s.add(opt);
				count++;
				total=total+mins[i];
				jobs[opt]-=1;
			}
		}
		System.out.println(count+" "+total+" "+(m-s.size()));
	}
 
	public static void main(String[] args) throws IOException {	
		int t=in.nextInt();
		int n,m,jobs[];
		String qual[];
		long mins[],offers[];
		for(int i=0;i<t;i++){
			n=in.nextInt();
			m=in.nextInt();
			mins=new long[n];
			offers=new long[m];
			jobs=new int[m];
			qual=new String[n];
			for(int j=0;j<n;j++)
				mins[j]=in.nextLong();
			for(int j=0;j<m;j++){
				offers[j]=in.nextLong();
				jobs[j]=in.nextInt();
			}
			for(int k=0;k<n;k++){
					qual[k]=in.next();
			}
			solve(n,m,mins,offers,jobs,qual);
		}
	}
} 
