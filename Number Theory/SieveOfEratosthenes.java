public static void primes(boolean ar[],int n){
		int c=2;
		ar[0]=true;
		while(c*c<=n){
			if(!ar[c]){
		for(int i=2*c;i<=n;i+=c){
			if(ar[i])continue;
			if(i!=c&&i%c==0)ar[i]=true;
		}
		}
		c++;
		}
}

//If false then prime else non prime..!!
