
public class NextPermutation {
	
	void swap(int a[],int index1,int index2){
		int temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
	void reverse(int a[],int start,int end){  //Start should be equal to k+1 but end should be less than end
		int temp;
		int temp_a[]=new int[end-start];
		for(int i=0;i<temp_a.length;i++)
			temp_a[i]=a[start++];
		for(int i=0;i<temp_a.length;i++){
			a[--end]=temp_a[i];
		}
	}
	void next_permutation(int ar[]){
		int k=0,l=0;
		int index=0;
		while(index<ar.length-1){
			if(ar[index]<ar[index+1])k=index;
			index++;
		}
		int value=ar[k];
		for(int i=k+1;i<ar.length;i++){
			if(value<ar[i])l=i;
		}
		swap(ar,k,l);
		if(k!=l)reverse(ar,k+1,ar.length);  
	}	
}
