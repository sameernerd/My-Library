import java.util.*;
public class knapsack {
	
	public static int Knapsack(int total,int n,int w[],int v[]){
		int dp[][]=new int[n][total+1];
		//If the weight is 0 no matter what is the weight profit will be zero
		for(int j=0;j<n;j++)
			dp[0][j]=0;
	    
		for(int i=0;i<n;i++){
			for(int j=1;j<=total;j++){
				if(i==0){
					if(j>=w[i])dp[i][j]=v[i];
					else dp[i][j]=0;
				}
				else{
					if(j<w[i])dp[i][j]=dp[i-1][j];
					else dp[i][j]=max(dp[i-1][j],v[i]+dp[i-1][j-w[i]]);
				}
			}
		}
		return dp[n-1][total];
	}
	
	public static int max(int a,int b){
		if(a>b)return a;
		else return b;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int total_weight=in.nextInt();
		int n=in.nextInt();
		int weight[]=new int[n];
		int value[]=new int[n];
		//Entering weight
		for(int i=0;i<n;i++)
			weight[i]=in.nextInt();
		for(int i=0;i<n;i++)
			value[i]=in.nextInt();
		
		System.out.println(Knapsack(total_weight,n,weight,value));
	}

}
