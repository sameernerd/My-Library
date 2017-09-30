import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class ContestMain {
	private static final int N=(int) 2e5+5; //200005
	private static Scanner in=new Scanner(System.in);
	private static ArrayList<Integer> v[]=new ArrayList[N];
	private static boolean mark[]=new boolean[N];
  
	public static void dfs(int node,int parent){
		mark[node]=true;
		for(int next:v[node]){
			if(!mark[next]){
				dfs(next,node);
			}
		}
		out.println(node);
	}
	public static void main(String[] args) throws IOException{
		int n=in.nextInt();
		int x,y;
		for(int i=0;i<n;i++){
			x=in.nextInt();
			y=in.nextInt();
			if(v[x]==null)v[x]=new ArrayList<Integer>();
			if(v[y]==null)v[y]=new ArrayList<Integer>();
			v[x].add(y);
			v[y].add(x);
		}
	}
}
