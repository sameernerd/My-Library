static int binarySearch(int ar[],int l,int r,int x){
		int mid,index;
		while(l<=r){
			mid=l+(r-l)/2;
			if(ar[mid]==x)return mid;
			else if(x<ar[mid]){
				l=mid+1;
			}
			else r=mid-1;
		}
		return -1;
	}
