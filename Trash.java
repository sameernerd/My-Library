/*
 * Remember a 7.0 student can know more than a 10.0 student.
 * Grades don't determine intelligence, they test obedience. 
 * I Never Give Up.
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.text.*;

import static java.lang.System.out;
import static java.util.Arrays.*;
import static java.lang.Math.*;
public class ContestMain {
	private static Reader in=new Reader();
	private static StringBuilder ans=new StringBuilder();
	private static long MOD=1000000007;//10^9+7 
//	private static final int N=100000; //10^5
//	private static final int LIM=26;
//	private static final double PI=3.1415;
//	private static ArrayList<Integer> v[]=new ArrayList[N];
//	private static int color[]=new int[N]; //For Graph Coloring
//	private static boolean mark[]=new boolean[N];
//	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	private static void dfs(int node){mark[node]=true;for(int x:v[node]){if(!mark[x]){dfs(x,v);}}}
//	private static long powmod(long x,long n,long m){
//		if(n==0)return 1;
//		else if(n%2==0)return(powmod((x*x)%m,n/2,m));
//		else return (x*(powmod((x*x)%m,(n-1)/2,m)))%m;
//	}
//	private static void shuffle(long [] arr) {
//		for (int i = arr.length - 1; i >= 2; i--) {
//			int x = new Random().nextInt(i - 1);
//	        long temp = arr[x];
//	        arr[x] = arr[i];
//	        arr[i] = temp;
//	    }
//	 }
//	private static void swap(int i,int j,int ar[]){
//		int temp=ar[i];
//		ar[i]=ar[j];
//		ar[j]=temp;
//	}
//	private static long gcd(long a, long b){
//		if(b==0)return a;
//		return gcd(b,a%b);
//	}
	private static ArrayList<Integer> ar=new ArrayList();
	private static ArrayList<Integer> lazy=new ArrayList();
	private static ArrayList<Integer> input=new ArrayList();
	private static void build(int low,int high,int pos,String s){
		if(low==high){
			if(input.get(low)==1)ar.set(pos,1);
			return;
		}
		int mid=(low+high)/2;
		build(low,mid,2*pos+1,s);
		build(mid+1,high,2*pos+2,s);
		int sum=ar.get(2*pos+1)+ar.get(2*pos+2);
		ar.set(pos,sum);
	}
	private static int query(int low,int high,int qlow,int qhigh,int pos){
		if(lazy.get(pos)!=0){
			if(low!=high){
				lazy.set(2*pos+1,lazy.get(pos));
				lazy.set(2*pos+2,lazy.get(pos));
				if(lazy.get(pos)==1)ar.set(pos,high-low+1);
				else if(lazy.get(pos)==0)ar.set(pos,0);
			}
			else{
				if(lazy.get(pos)==1)ar.set(pos,1);
				else if(lazy.get(pos)==2)ar.set(pos,0);
				else if(lazy.get(pos)==3){
					if(ar.get(pos)==1)ar.set(pos,0);
					else ar.set(pos,1);
				}
			}
			lazy.set(pos,0);
		}
		if(qlow>high||qhigh<low)return 0;
		if(qlow<=low&&qhigh>=high)return ar.get(pos);
		int mid=(low+high)/2;
		return ar.get(2*pos+1)+ar.get(2*pos+2);
	}
	private static void update(int low,int high,int qlow,int qhigh,int pos,int opt){
		int x,y;
		if(low>high)return;
		if(lazy.get(pos)!=0){
			if(low!=high){
				x=lazy.get(2*pos+1);
				y=lazy.get(2*pos+2);
				if(opt==3){
					if(x==1)lazy.set(2*pos+1,2);
					else if(x==2)lazy.set(2*pos+1,1);
					else lazy.set(2*pos+1,0);
					if(y==1)lazy.set(2*pos+2,2);
					else if(y==2)lazy.set(2*pos+2,1);
					else lazy.set(2*pos+2,0);
					
				}
				else if(opt==1){
					lazy.set(2*pos+1,1);
					lazy.set(2*pos+2,1);
				}
				else {
					lazy.set(2*pos+1,2);
					lazy.set(2*pos+2,2);
				}
			}
			lazy.set(pos,0);
		}
		if(qlow>high||qhigh<low)return;
		if(qlow<=low&&qhigh>=high){
			if(opt==3){
				ar.set(pos,high-low+1-ar.get(pos));
				if(lazy.get(2*pos+1)!=0){
					if(lazy.get(2*pos+1)==1)lazy.set(2*pos+1,2);
					else lazy.set(2*pos+1,1);
				}
				else lazy.set(2*pos+1,3);
				if(lazy.get(2*pos+2)!=0){
					if(lazy.get(2*pos+2)==1)lazy.set(2*pos+2,2);
					else lazy.set(2*pos+2,1);
				}
				else lazy.set(2*pos+2,3);
			}
			else if(opt==1)ar.set(pos,high-low+1);
			else ar.set(pos,0);
			return;
		}
		int mid=(low+high)/2;
		update(low,mid,qlow,qhigh,2*pos+1,opt);
		update(mid+1,high,qlow,qhigh,2*pos+2,opt);
		ar.set(pos,ar.get(2*pos+1)+ar.get(2*pos+2));
	}
	public static void main(String[] args) throws IOException{
		int t=in.nextInt();
		int n,x,ind,q,l,r;
		String s = null;
		String ch;
		while(t-->0){
			n=in.nextInt();
			while(n-->0){
				x=in.nextInt();
				ind=0;
				s=in.next();
				while(x!=0){
					if(s.charAt(ind)=='1')input.add(1);
					else input.add(0);
					ind++;
					if(ind==s.length()){
						x--;
						ind=0;
					}
				}
			}
			for(int i=0;i<4*input.size();i++){
				lazy.add(0);
				ar.add(0);
			}
			build(0,input.size()-1,0,s);
			q=in.nextInt();
			while(q-->0){
				ch=in.next();
				l=in.nextInt();
				r=in.nextInt();
				if(ch.equals("F"))update(0,input.size()-1,l,r,0,1);
				else if(ch.equals("E"))update(0,input.size()-1,l,r,0,2);
				else if(ch.equals("I"))update(0,input.size()-1,l,r,0,3);
				else out.println(query(0,input.size()-1,l,r,0));
			}
			input.clear();lazy.clear();ar.clear();
		}
	}
	static class Pair<T> implements Comparable<Pair>{
		int l;
		int r;
		Pair(){
			l=0;
			r=0;
		}
		Pair(int k,int v){
			l=k;
			r=v;
		}
		@Override
		public int compareTo(Pair o) {
			if(o.l!=l)return (int) (l-o.l);
			else return (r-o.r);
		}
		
	}
	static class Reader{
        BufferedReader br;
        StringTokenizer st;
        public Reader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
     
                	st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
