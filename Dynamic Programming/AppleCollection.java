import java.util.*;
public class AppleCollection {
	
	public static int CollectApple(int A[][],int r,int c){
		int S[][]=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++)
				S[i][j]=0;
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(i!=0&&j!=0)S[i][j]=A[i][j]+max(S[i-1][j],S[i][j-1]);
				else if(i==0&&j!=0)S[i][j]=A[i][j]+S[i][j-1];
				else if(i!=0&&j==0)S[i][j]=A[i][j]+S[i-1][j];
				else S[i][j]=A[i][j];
			}
		}
		return S[r-1][c-1];
	}
	
	static int max(int a,int b){
		if(a>b)return a;
		else return b;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int rows=in.nextInt();
		int cols=in.nextInt();
		int ar[][]=new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++)
				ar[i][j]=in.nextInt();
		}
		System.out.print(CollectApple(ar,rows,cols));
	}
}
