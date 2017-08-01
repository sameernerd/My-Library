/*Formula Used :-
 * Left-Child :- 2*parentIndex+1
 * Right-Child :- 2*parentIndex+2
 * Parent :- (childIndex-1)/2
 */
public class SegmentTree {
	private int segment_array[]=new int[1000001];
	private int lazy[]=new int[1000001];
	private int input[];
	SegmentTree(){
		for(int i=0;i<segment_array.length;i++)
			segment_array[i]=Integer.MAX_VALUE;
		for(int i=0;i<lazy.length;i++)
			lazy[i]=0;
	}
	
	public void constructTreeSum(int input[],int low,int high,int pos){
		if(low==high){
			segment_array[pos]=input[low];
			return;
		}
		int mid=(low+high)/2;
		constructTreeSum(input,low,mid,2*pos+1);
		constructTreeSum(input,mid+1,high,2*pos+2);
		segment_array[pos]=segment_array[2*pos+1]+segment_array[2*pos+2];
	}
	
	public void constructTreeMin(int input[],int low,int high,int pos){
		if(low==high){
			segment_array[pos]=input[low];
			return;
		}
		int mid=(low+high)/2;
		constructTreeMin(input,low,mid,2*pos+1);
		constructTreeMin(input,mid+1,high,2*pos+2);
		segment_array[pos]=Math.min(segment_array[2*pos+1],segment_array[2*pos+2]);
	}
	
	public int sumRangeQuery(int qlow,int qhigh,int low,int high,int pos){
		if(qlow<=low&&qhigh>=high){ //Total Overlap
			return segment_array[pos];
		}
	    if(qlow>high||qhigh<low){ //No Overlap
			return 0;
		}
	  //Partial Overlap
	    int mid=(low+high)/2;
		return sumRangeQuery(qlow,qhigh,low,mid,2*pos+1)
		                +sumRangeQuery(qlow,qhigh,mid+1,high,2*pos+2);
	}
	
	public int minRangeQuery(int qlow,int qhigh,int low,int high,int pos){
		if(lazy[pos]!=0){
			segment_array[pos]+=lazy[pos];
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
		if(qlow<=low&&qhigh>=high){
			return segment_array[pos];
		}
		if(qlow>high||qhigh<low){
			return Integer.MAX_VALUE;
		}
		int mid=(low+high)/2;
		return Math.min(minRangeQuery(qlow,qhigh,low,mid,2*pos+1),
				minRangeQuery(qlow,qhigh,mid+1,high,2*pos+2));
		
	}
	
	public void updateMinRange(int data,int qlow,int qhigh,int low,int high,int pos){
		if(low>high)return;
		if(lazy[pos]!=0){
			segment_array[pos]+=lazy[pos];
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
				lazy[pos]=0;
			}
		}
		if(qlow>high||qhigh<low){ //No overlap
			return; 
		}
		if(qlow<=low&&qhigh>=high){//Total Overlap
			segment_array[pos]+=data;
			lazy[2*pos+1]+=data;
			lazy[2*pos+2]+=data;
			return;
		}
		int mid=(low+high)/2;
		updateMinRange(data,qlow,qhigh,low,mid,2*pos+1);
	    updateMinRange(data,qlow,qhigh,mid+1,high,2*pos+2);
	    segment_array[pos]=Math.min(segment_array[2*pos+1], segment_array[2*pos+2]);
	}
}
