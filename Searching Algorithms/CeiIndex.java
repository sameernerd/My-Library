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
