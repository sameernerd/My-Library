
public class KMPSearch {
	String pattern,original_string;
	PrefixedArray pOb=new PrefixedArray();
	int pre_array[];
	int count=0;
	
	//Constructor 1 of this class in any case
	KMPSearch(){}
	//Constructor 2 of this class
	KMPSearch(String str,String p){
		pattern=p;
		original_string=str;
		pre_array=pOb.getPrefixedArray(pattern);  //Getting prefixed array of the pattern 
	}
	
	
	boolean KMPSubstring(){
		int i=0,j=0;
		while(j<pattern.length()&&i<original_string.length()){
			if(pattern.charAt(j)==original_string.charAt(i)){
				i++;
				j++;
			}
			else{
				if(j!=0)j=pre_array[j-1];
				else {
					i++;
				}
			}
		}
		if(j==pattern.length())return true;
		else return false;
		
	}
}
