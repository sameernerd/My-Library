/*
 * Remember a 6.89 student can know more than a 10.0 student.
 * Grades don't determine intelligence, they test obedience. 
 * I Never Give Up.
 * I will become Candidate Master today.
 * I will defeat Saurabh Anand.
 * Skills are Cheap,Passion is Priceless.
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

import static java.lang.System.out;
import static java.util.Arrays.*;
import static java.lang.Math.*;
 
class ContestMain{
	private static Reader in=new Reader();
	private static StringBuilder ans=new StringBuilder();
	private static long MOD=(long)1e9+7;
	private static long INF=(long)1e12;
	private static final int N=(int) (1e5+7); // 1e5+7
    private static final double EPS=1e-9;
    private static final int LIM=26;
    private static final double PI=3.1415;
    private static ArrayList<Integer> v[]=new ArrayList[N];
//    private static int color[]=new int[N];
	private static boolean mark[]=new boolean[N];
//    private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//    private static ArrayList<Pair> v[]=new ArrayList[N];
	private static long powmod(long x,long n){
		if(n==0||x==0)
			return 1;
		else if(n%2==0)
			return(powmod((x*x)%MOD,n/2));
		else
			return (x*(powmod((x*x)%MOD,(n-1)/2)))%MOD;
	}
	private static void shuffle(long[] arr){
		for(int i=arr.length-1;i>=2;i--){
			int x=new Random().nextInt(i-1);
			long temp=arr[x];
			arr[x]=arr[i];
			arr[i]=temp;
		}
	}
	private static void shuffle(int[] arr){
		for(int i=arr.length-1;i>=2;i--){
			int x=new Random().nextInt(i-1);
			int temp=arr[x];
			arr[x]=arr[i];
			arr[i]=temp;
		}
	}
    private static long gcd(long a, long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
//    private static boolean check(int x,int y){
//        if((x>=0&&x<n)&&(y>=0&&y<m)&&mat[x][y]!='X'&&!visited[x][y])return true;
//        return false;
//    }
    static int bit[]=new int[200007];
    public static long sum(int x){
    	long sum=0;
    	while(x>0){
    		sum+=bit[x];
    		x-=x&-x;
    	}
    	return sum;
    }
    public static void update(int x,int data,int n){
    	while(x>0&&x<=n){
    		bit[x]+=data;
    		x+=x&-x;
    	}
    }
    public static int krank(int k,int n){
    	int l=1,r=n,mid;
    	while(l<r){
    		mid=(l+r)/2;
    		if(sum(mid)<k)l=mid+1;
    		else r=mid;
    	}
    	return l;
    }
	public static void main(String[] args) throws IOException{
		int t=in.nextInt();
		int n,ar[],c,res[];
		while(t-->0){
			n=in.nextInt();
			ar=new int[n];
			res=new int[n];
			for(int i=0;i<n;i++)
				ar[i]=in.nextInt();
			for(int i=1;i<=n;i++)
				update(i,1,n);
			for(int i=n-1;i>=0;i--){
				c=krank(i+1-ar[i],n);
				res[i]=c;
				update(c,-1,n);
			}
			for(int i=0;i<n;i++)
				app(res[i]+" ");
			app("\n");
		}
		pn(ans);
	}
	static class Pair<T> implements Comparable<Pair>{
		int l;
		int r;
		int req_node;
		Pair(){
			l=0;
			r=0;
		}
		Pair(int k,int v,int o){
			l=k;
			r=v;
			req_node=o;
		}
		@Override
		public int compareTo(Pair o){
			if(l!=o.l)return (int)(l-o.l);
			return (int)(r-o.r);
			
		}
		// Fenwick tree question comparator
//        @Override
//        public int compareTo(Pair o) {
//            if(o.r!=r)return (int) (r-o.r);
//            else return (int)(l-o.l);
//        }
	}
	//Reader Class
	static class Reader{
		BufferedReader br;
		StringTokenizer st;
		public Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st=new StringTokenizer(br.readLine());
				}catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(next());}
		long nextLong(){return Long.parseLong(next());}
		double nextDouble(){return Double.parseDouble(next());}
		String nextLine(){
			String str="";
			try{
				str=br.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}
	//Printer Methods
	static void pn(Object o){out.print(o);}
	static void pln(Object o){out.println(o);}
	static void pln(){out.println();}
	//Appenders
	static void app(Object o){ans.append(o);}
}