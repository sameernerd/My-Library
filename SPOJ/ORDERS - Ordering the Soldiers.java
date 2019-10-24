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
	
	/*Solution Start*/
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
	/*Solution End*/
	
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
