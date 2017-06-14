import java.util.*;
public class flyod_warshall {
	
	static void FloydWarshall(int d[][],int p[][],int n){
		//This algorithm will take two two-dimensional array one for distance(cost) and other for path
		//The time complexity of this algorithm is O(n3)
		int distance[][];
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(d[i][j]>(d[i][k]+d[k][j])){
						d[i][j]=d[i][k]+d[k][j];
						p[i][j]=p[k][j]; //Last node will be the entry node and node to j from can be shortest will be i->k->j
					}
				}
			}
		}
	}
	static void FindPoint(int path[][],int i,int j){		
		Deque<Integer> stack=new LinkedList();
		stack.addFirst(j);
		while(true){
			j=path[i][j];
			if(path[i][j]==-1)break;
			stack.addFirst(j);
			if(i==j){
				break;
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pollFirst()+"->");
		}
	}
	
	private static int MAX=999999999;
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		int n=read.nextInt();
		int no_edges=read.nextInt();
		int distance[][]=new int[n][n];
		int path[][]=new int[n][n];
		//Initializing the matrix
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j)distance[i][j]=0;
				else distance[i][j]=MAX;
				path[i][j]=-1;  //Initializing path here only
			}	
		}
		int x,y;
		for(int i=0;i<no_edges;i++){
			x=read.nextInt();
			y=read.nextInt();
			distance[x][y]=read.nextInt();
			path[x][y]=x;
		}
		FloydWarshall(distance,path,n);
		FindPoint(path,0,2);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(distance[i][j]+" ");
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(path[i][j]+" ");
			System.out.println();
		}
		
		read.close();
	}
}
