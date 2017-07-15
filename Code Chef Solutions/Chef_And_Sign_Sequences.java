import java.util.*;
 class meramainmahan {
	
	public static int solve(String str){
		int ar[]=new int[str.length()+1];
		int max=1;
		for(int i=0;i<ar.length;i++)
			ar[i]=1;
		for(int i=1;i<ar.length;i++){
			if(str.charAt(i-1)=='<'){
				if(ar[i-1]>=ar[i]){
					ar[i]=ar[i-1]+1;
				}
			}
			else if(str.charAt(i-1)=='>'){
				if(ar[i-1]<=ar[i]){
				    ar[i-1]=ar[i]+1;
				}
			}
			else if(str.charAt(i-1)=='=')ar[i]=ar[i-1];
		}
		for(int i=ar.length-1;i>=1;i--){
			if(str.charAt(i-1)=='<'){
				if(ar[i-1]>=ar[i]){
					ar[i]=++ar[i-1];
				}
			}
			else if(str.charAt(i-1)=='>'){
				if(ar[i-1]<=ar[i]){
				    ar[i-1]=ar[i]+1;
				}
			}
			else if(str.charAt(i-1)=='=')ar[i-1]=ar[i];
		}
		for(int i=0;i<ar.length;i++){
			//System.out.print(ar[i]+" ");
			if(ar[i]>max)max=ar[i];
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		String str;
		for(int i=0;i<t;i++){
			str=in.next();
			System.out.println(solve(str));
		}
	}

}
