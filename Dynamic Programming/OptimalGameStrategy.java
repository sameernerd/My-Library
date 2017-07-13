   //This solution is not suitable for big test cases.
   //But it works..
   //This solution needs to be improved.
    static class node{
        long a,b;
        node(){
            a=0;
            b=0;
        }
    }
    public static long solve(int n,int ar[]){
        node dp[][]=new node[n+1][n+1];
        node newNode;
        int count=0;
        long sum=0,temp,m=0;
        while(count<=n){
            for(int i=1;i+count<=n;i++){
            if(count<3){
                sum=0;
                for(int k=0;k<=count;k++){
                    sum=sum+ar[i+k];
                }
                newNode=new node();
                newNode.a=sum;
                newNode.b=0;
                dp[i][i+count]=newNode;
            }
            else{
                m=0;
                newNode=new node();
                for(int k=0;k<=2;k++){
                    temp=max(m,dp[i][i+k].a+dp[i+k+1][i+count].b);
                    if(temp>m){
                        m=temp;
                        newNode.a=m;
                        newNode.b=dp[i+k+1][i+count].a;
                    }
                }
                dp[i][i+count]=newNode;
            }
        }
            count++;
       }
        return dp[1][n].a;
    }
