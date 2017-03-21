
public class PrefixedArray {
	int pa[];
	
	//Looking Back
	int SearchBack(int ar[],int j,int i,String str){
		for(int c=j-1;c>=0;c--){
			j=pa[c];
			if(str.charAt(j)==str.charAt(i)){
				pa[i]=j+1;
				break;
			}
			else if(j==0 && str.charAt(j)!=str.charAt(i))pa[i]=0;
			else continue;
		}
		return j;
	}
	
	//Method to get Prefixed Array
	int[] getPrefixedArray(String s){
		int j=0,i=1;
		pa=new int[s.length()];
		pa[0]=0;
		for(int k=1;k<s.length();k++){
			if(s.charAt(j)==s.charAt(i)){
				pa[k]=j+1;
				j++;i++;
			}
			else{
				j=SearchBack(pa,j,i,s);
				i++;
			}
		}
		return pa;
	}
}

//If valueAt(i)==valueAt(j) then put j+1 in the pa and i++ j++
/*
 * If valueAt(i)!=valueAt(j) then come back 1 place and now j=that_back_value
 * and now check if the valueAt(j)==valueAt(i) if not repeat this step till j=0
 * if then also not found insert 0
 */
