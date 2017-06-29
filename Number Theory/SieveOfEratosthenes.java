import java.util.*;
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		int n=read.nextInt();
		int ar[]=new int[n+1];
		ar[0]=0;ar[1]=1;
		int c=2;
		for(int i=2;i<=n;i++)
			ar[i]=i;
		while(c*c<=n){
			if(ar[c]!=-1){
		for(int i=2*c;i<=n;i+=c){
			if(ar[i]==-1)continue;
			if(i!=c&&ar[i]%c==0)ar[i]=-1;
		}
		}
		c++;
	}
		for(int i=2;i<=n;i++)
			if(ar[i]!=-1)System.out.println(ar[i]);
	}
}
