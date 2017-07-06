 public static void BigFactorial(int n,ArrayList<Integer> ar){
        int mult,carriage=0;
        ar.add(1);
        for(int i=2;i<=n;i++){
            for(int c=0;c<ar.size();c++){
                mult=(ar.get(c)*i)+carriage;
             
                ar.set(c,mult%10);
                carriage=mult/10;
        }
            while(carriage!=0){
                ar.add(carriage%10);
                carriage=carriage/10;
            }
     }
       
  }
