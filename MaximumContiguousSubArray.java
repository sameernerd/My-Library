
public class MaximumSubArray {
	
	int[] MaxCrossSubArray(int ar[],int low,int mid,int high){
		int maxcross[]=new int[3];
		int left_sum=-1000000,right_sum=-1000000;
		int sum=0;
		int max_left=-1,max_right=-1;
		for(int i=mid;i>=0;i--){
			sum=sum+ar[i];
			if(sum>left_sum){
				left_sum=sum;
				max_left=i;
			}
		}
		sum=0;
		for(int i=mid+1;i<=high;i++){
			sum=sum+ar[i];
			if(sum>right_sum){
				right_sum=sum;
				max_right=i;
			}
		}
		maxcross[0]=max_left;
	    maxcross[1]=max_right;
	    maxcross[2]=left_sum+right_sum;
		return maxcross;
	}
	
	int[] MaxSubarray(int ar[],int low,int high){
		int maxleft[]=new int[3];
		int maxright[]=new int[3];
		int crosssum[]=new int[3];
		int maxsum[]=new int[3];
		int mid;
		if(high==low){
			maxsum[0]=low;
			maxsum[1]=high;
			maxsum[2]=ar[low];
			return maxsum;
		}
		else mid=(high+low)/2;
		int left_sum=-10000,right_sum=-10000;
		maxleft=MaxSubarray(ar,low,mid);
		maxright=MaxSubarray(ar,mid+1,high);
		crosssum=MaxCrossSubArray(ar,low,mid,high);
		if(maxleft[2]>=maxright[2]&&maxleft[2]>=crosssum[2])return maxleft;
		else if(maxright[2]>=maxleft[2]&&maxright[2]>=crosssum[2])return maxright;
		else return crosssum;
	}
}
