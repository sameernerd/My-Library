import java.util.*;
public class long_pallindrom {
	
	static void LongestPallindromicSubsequenec(int d[][],String str){
		int n=str.length();
		int index;
		for(int i=0;i<n;i++)
			d[i][i]=1;
		
		for(int l=2;l<=n;l++){
			for(int j=0;j<n-l+1;j++){
				index=j+l-1;
				if(l==2&&str.charAt(j)==str.charAt(index)){
					d[j][index]=2;
				}
				else if(str.charAt(j)==str.charAt(index)){
					d[j][index]=2+d[j+1][index-1];
				}
				else{
					d[j][index]=max(d[j+1][index],d[j][index-1]);
				}
			}
		}
	}
	
	 static int max(int a,int b){
		 if(a>b)return a;
		 else return b;
	 }

	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		String str=read.next();
		int dynamic[][]=new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++){
			for(int j=0;j<str.length();j++)
				dynamic[i][j]=0;
		}
		LongestPallindromicSubsequenec(dynamic,str);
		for(int i=0;i<dynamic.length;i++){
			for(int j=0;j<dynamic.length;j++)
				System.out.print(dynamic[i][j]+" ");
			System.out.println();
		}
	}
}
