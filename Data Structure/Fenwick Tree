/*
 * If you find any bug please open the issue and 
 * I will try to fix it as soon as possible.
 */
import java.util.*;
public class FenwickMain {
	/* How to get parent in 
	 * 1.)2's complement of number
	 * 2.)AND it with original number
	 * 3.)Add result to the original number
	 */
	/* How to get next index to update
	 * 1.)2's complement of number
	 * 2.)AND it with the original number
	 * 3.)Subtract from original number
	 */
	static long bit[],ar[];
	static int n;
	public static long query(int l,int r){
		int sum_l=0,sum_r=0;
		int curr_ind=l;
		while(curr_ind!=0){
			sum_l+=bit[curr_ind];
			curr_ind=curr_ind-(-curr_ind&curr_ind);
		}
		curr_ind=r+1;
		while(curr_ind!=0){
			sum_r+=bit[curr_ind];
			curr_ind=curr_ind-(-curr_ind&curr_ind);
		}
		return sum_r-sum_l;
	}
	public static void updateReplace(int ind,int val){
		long prev_val=ar[ind];
		ar[ind]=val; //If replacing or use ar[ind]+=val to add
		int next=ind+1; //In fenwick tree we work with ind+1 where ind is original index of given array
		while(next<=n){
			bit[next]+=ar[ind]-prev_val;
			next=next+(next&-next);
		}
	}
	public static void updateAdd(int ind,int val){
		ar[ind]+=val; //If replacing or use ar[ind]+=val to add
		int next=ind+1; //In fenwick tree we work with ind+1 where ind is original index of given array
		while(next<=n){
			bit[next]+=val;
			next=next+(next&-next);
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		ar=new long[n];
		bit=new long[n+1];
		for(int i=0;i<n;i++)
			ar[i]=in.nextInt();
		int next;
		for(int i=1;i<=n;i++){
			next=i;
			while(next<=n){
				bit[next]+=ar[i-1];
				next=(-next&next)+next;
			}
		}
		System.out.println(query(0,4));
		updateReplace(2,13);
		updateReplace(1,5);
		System.out.println(query(1,4));
	}
}
