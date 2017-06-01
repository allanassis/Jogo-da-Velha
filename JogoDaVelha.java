import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha{
    public static void matriz(char[][] jv){
            System.out.println("    0   1   2\n");
            System.out.println("0  _"+jv[0][0]+"_|_"+jv[0][1]+"_|_"+jv[0][2]+"_");
            System.out.println("1  _"+jv[1][0]+"_|_"+jv[1][1]+"_|_"+jv[1][2]+"_");
            System.out.println("2   "+jv[2][0]+" | "+jv[2][1]+" | "+jv[2][2]+" ");
            System.out.println("=========================================================");
           
        
    }
    public static void zerar(char[][] jv){
        for(int i=0;i<jv.length;i++){
            for(int j=0;j<jv[0].length;j++){
                jv[i][j]='_';
            }
        }
    }
    public static int verificar(char[][] jv){
        String verificar = "XXX";
        String verificar2 = "OOO";
        char[] c = new char[3];
        char[] d = new char[3];
        char[] e = new char[3];
        char[] f = new char[3];
        for(int i = 0; i<jv.length;i++){
            e[i]=jv[i][i];
            f[i]=jv[i][2-i];
            if(String.copyValueOf(e).equals(verificar) || String.copyValueOf(f).equals(verificar)){
                return 0;
            }
            else if(String.copyValueOf(e).equals(verificar2) || String.copyValueOf(f).equals(verificar2)){
                return 1;
            }
            
            for(int j = 0;j<jv[0].length;j++){
                c[j]=jv[i][j];
                d[j]=jv[j][i];
            }
            if(String.copyValueOf(c).equals(verificar) || String.copyValueOf(d).equals(verificar)){
                return 0;
            }
            else if(String.copyValueOf(c).equals(verificar2) || String.copyValueOf(d).equals(verificar2)){
                return 1;
            }
            
        }
        return 2;
    }
    public static void inserir(char[][] jv, int x, int y,char m){
        
        if(jv[x][y]=='_'){
            jv[x][y]=m;
        }
        else
            System.out.println("escolha uma posição vazia");
    }
        
    
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        Random rand = new Random();
        
        char[][] jv = new char[3][3];
        
        int controle=0;
        
        zerar(jv);
        
        while(controle==0){
            
            int x=0,y=0;

            matriz(jv);

            x = Integer.parseInt(input.next());
            y = Integer.parseInt(input.next());

            inserir(jv,x,y,'X');
            
            if(verificar(jv)==0){
                matriz(jv);
                System.out.println("Voce venceu!");
                System.out.println("Se desejar continuar digite 0, se não digite qualquer outro numero.");
                controle = Integer.parseInt(input.next());
                zerar(jv);
                continue;
                
            }
            
            matriz(jv);
            
            do{
                
                x = rand.nextInt(3);
                y = rand.nextInt(3);
                
            }while(jv[x][y]!='_');
            
            inserir(jv,x,y,'O');
            
            if(verificar(jv)==1){
                matriz(jv);
                System.out.println("Voce perdeu!");
                System.out.println("Se desejar continuar digite 0, se não digite qualquer outro numero.");
                controle = Integer.parseInt(input.next());
                zerar(jv);
            
                
            }
        }
    }
}
           