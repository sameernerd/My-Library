import java.util.*;

public class dp {
	//n^2 time complexity
	static int LongestInceresingSubsequence(int ar[],int n){
		int max=0;
		int length[]=new int[n];
		//Taking only one number that is itself
		for(int i=0;i<n;i++)
			length[i]=1;
		int i=1,j=0;
		while(i<n){
			if(ar[j]<ar[i]){
				length[i]=max(length[i],length[j]+1);
			}
			j++;
			if(j==i){
				j=0;
				i++;
			}
		}
		return max;
	}
	static int LongestIncreasingSubsequence2(int ar[],int n){
		int R[]=new int[n];  //It will store the final result
		int T[]=new int[n];  //Minimum of the last value of increasing subsequence of length (i+1)
		int len=0; //length of the LSI-1
		int index=-1;
		for(int i=0;i<n;i++)
			R[i]=-1;
		T[0]=0;
		for(int i=1;i<n;i++){
			if(ar[i]>=ar[T[len]]){
				T[++len]=i;
				R[T[len]]=T[len-1];
			}
			else if(ar[i]<=ar[T[0]]){
				T[0]=i;
			}
			else{
				index=ceilIndex(T,0,len,ar[i],ar);
				T[index]=i;
				R[T[index]]=T[index-1];
			}
		}
		return len;
	}
	static int max(int a,int b){
		if(a>b)return a;
		else return b;
	}
	static int ceilIndex(int ar[],int l,int r,int x,int o[]){
		int m;
		while(r-l>1){
			m=(l+r)/2;
			if(x==o[ar[m]])return m;
			else if(x<=o[ar[m]]){
				r=m;
			}
			else l=m;
		}
		return r;
	}
	public static void main(String[] args) {
		//Scanner in=new Scanner(System.in);
		//int n=in.nextInt();
		//int ar[]=new int[n];
		//for(int i=0;i<n;i+ +){
			//ar[i]=in.nextInt();
		//}
		//int max_len=LongestInceresingSubsequence(ar,n);
		//System.out.println(max_len);
		int ar2[]={3,4,-1,5,8,2,3,12,7,9,10};
		int n=LongestIncreasingSubsequence2(ar2,ar2.length);
		System.out.println(n);
	}

}
