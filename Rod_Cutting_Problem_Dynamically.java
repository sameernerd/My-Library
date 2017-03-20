
public class Rod_Cutting_Problem_Dynamically {
	int r[];
	int q;
	
	int max(int x,int y){
		if(x>y)return x;
		else return y;
	}
	
	int RodCut(int price[],int n){
		r=new int[n+1];
		r[0]=0;  //Since rod of length 0 earns no revenue
		for(int i=1;i<=n;i++){
			q=-100001;    //Taking an arbitrary maximum value
			for(int j=1;j<=i;j++){
				q=max(q,price[j]+r[i-j]);
			}
			r[i]=q;
		}
		return r[n];
	}
}

/*
 * Bottom Up version of solving the rod cutting problem dynamically
 */