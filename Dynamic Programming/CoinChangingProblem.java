//k is the sum to obtained
    private static int MAX=999999;
    public static void solve(int coins[],int k){
        int result[]=new int[k+1];
        result[0]=0;
        for(int i=1;i<=k;i++)
            result[i]=MAX;
        
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=k;j++){
                if(coins[i]>j)continue;
                else result[j]=min(result[j],result[j-coins[i]]+1);
            }
        }
        
        for(int i=k;i>=0;i--){
            if(result[i]!=MAX){
                System.out.println(i);
                break;
            }
        }
    }
    
    static int min(int a,int b){
        if(a<b)return a;
        else return b;
    }
