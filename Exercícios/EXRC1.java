import java.util.*;

class EXRC1{

    public static void main(String[] args){
        try{    
            int tmnS,tmnQ;

            Scanner scan = new Scanner(System.in);

            tmnS = scan.nextInt();

            int[] S = new int[tmnS];

            for(int i = 0; i < tmnS; ++i){
                
                S[i] = scan.nextInt();
            }

            tmnQ = scan.nextInt();

            int[] Q = new int[tmnQ];

            for(int i = 0; i < tmnQ; ++i){
                
                Q[i] = scan.nextInt();
            }
            boolean p;

            int[] O = new int[tmnS];
            int output = 0;

            for(int i = 0; i < tmnS; ++i){

                p = false;

                for(int j = 0; j < tmnQ; ++j){
                   if(S[i] == Q[j]){
                     p = true;
                     break;
                   }
                }
                if(!p){
                    O[output++] = S[i];
                }
            }

            for(int i = 0; i < output; i++)
            {
                System.out.print(O[i]);
                
                if(i != output-1)
                    System.out.print(" ");
            }
        }catch (Exception ex){}
    }
}
