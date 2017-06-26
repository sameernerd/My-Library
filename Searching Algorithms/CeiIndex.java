static int CeilIndex(int ar[],int l,int r,int x){
		int m,index;
		while(l<=r){
			m=l+(r-l)/2;
			if(x>ar[r])return -1;
			if(x==ar[m])return m;
			else if(x<=ar[m]){
				r=m;
				return r;
			}
			else{
				l=m;
			}
		}
		return -1;
	}
