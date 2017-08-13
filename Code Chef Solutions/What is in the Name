import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 class meramainmahan {
	
	public static String solve(String str){
		String name="";
		int count=0;
		ArrayList<Integer> ar=new ArrayList();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				count++;
				ar.add(i+1);
			}
		}
		
		if(count==0)name=(str.charAt(0)+"").toUpperCase()+str.substring(1,str.length()).toLowerCase();
		else if(count==1){
			name=(str.charAt(0)+"").toUpperCase()+". "+(str.charAt(ar.get(0))+"").toUpperCase()+str.substring(ar.get(0)+1,str.length()).toLowerCase();
		}
		else if(count==2){
			name=(str.charAt(0)+"").toUpperCase()+". "+(str.charAt(ar.get(0))+". ").toUpperCase()+(str.charAt(ar.get(1))+"").toUpperCase()+str.substring(ar.get(1)+1,str.length()).toLowerCase();
		}
		return name;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		String str;
		for(int i=0;i<t;i++){
			str=br.readLine().trim();
			System.out.println(solve(str));
		}
	}

}
