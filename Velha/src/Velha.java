import java.util.Scanner;

public class Velha {
   
    public static void main(String[] args) {
        
    
   
    Campo[][] velha=new Campo[3][3];
    
    char simboloAtual='X';

    boolean game=true;

    char vitoria= ' ';

    Scanner scan=new Scanner(System.in);
   
     iniciarJogo(velha);

    while (game) {
        desenhaJogo(velha);
        vitoria = verificaVitoria(velha);
        if (vitoria !=' '){
            System.out.println("-----------------------------");
            System.out.printf("Jogador %s venceu%n", vitoria);
            System.out.println("-----------------------------");
            break;
        }

        if (verificaEmpate(velha)) {
            System.out.println("-----------------------------");
            System.out.println("Empate! Nenhum jogador venceu.");
            System.out.println("-----------------------------");
            break;
            }

        try{
            if (verificarJogada(velha,jogar(scan,simboloAtual),simboloAtual)) {
                if (simboloAtual == 'X' ) {
                    simboloAtual = 'O';
                }else{
                    simboloAtual = 'X';
                }
            }


        }catch(Exception e){
          
            System.out.println("     -Erro-");
            scan.nextLine();
        }
    }
    System.out.printf("Fim de Jogo !");
  }
 
  public static void desenhaJogo(Campo[][] velha) {
    System.out.println("    0   1   2");
    for (int i = 0; i < 3; i++) {
        System.out.printf("%d   %c | %c | %c %n", i,
            velha[i][0].getSimbolo(), velha[i][1].getSimbolo(), velha[i][2].getSimbolo());
        if (i < 2) {
            System.out.println("  ------------");
        }
    }
}


public static void  limparTela(){
    for(int cont= 0;cont < 200;cont++){
    System.out.println("");
    }
}


public static int[] jogar(Scanner scan, char sa){
    int p[] =new int[2];
    System.out.println("**********************************");
    System.out.printf("%s %c%n", "Quem joga: ", sa);
    System.out.print("Informe a linha: ");
    p[0]= scan.nextInt();
    System.out.print("Informe a coluna: ");
    p[1]= scan.nextInt();
    System.out.println("**********************************");
    return p;
}

public static boolean verificarJogada(Campo[][] velha, int p [], char simboloAtual){
   if (velha[p[0]][p[1]].getSimbolo()== ' ' ) {
    velha[p[0]][p[1]].setSimbolo(simboloAtual);
    return true;
   }else{
     return false;
   }
}

public static void iniciarJogo(Campo[][] velha){
    for(int  l=0;l< 3;l++){
        for(int c=0;c< 3;c++){
            velha[l][c]=new Campo();
        }
    }
}

public static boolean verificaEmpate(Campo[][] velha) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (velha[i][j].getSimbolo() == ' ') {
                return false; 
            }
        }
    }
    return true; 
}

public static char verificaVitoria(Campo[][] velha) {

    for (int i = 0; i < velha.length; i++) {

        if (velha[i][0].getSimbolo() == 'X' && velha[i][1].getSimbolo() == 'X' && velha[i][2].getSimbolo() == 'X' || velha[i][0].getSimbolo() == 'O' && velha[i][1].getSimbolo() == 'O' && velha[i][2].getSimbolo() == 'O') {
            return velha[i][0].getSimbolo();
        }
    }
    for (int i = 0; i < velha.length; i++) {
        if (velha[0][i].getSimbolo() == 'X' && velha[1][i].getSimbolo() == 'X' && velha[2][i].getSimbolo() == 'X' || velha[0][i].getSimbolo() == 'O' && velha[1][i].getSimbolo() == 'O' && velha[2][i].getSimbolo() == 'O') {
            return velha[0][i].getSimbolo();
        }

    }

    if ((velha[0][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X') || (velha[0][2].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O')) {
        return velha[1][1].getSimbolo();
    }

    if((velha[0][0].getSimbolo() =='O' && velha[1][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O') || (velha[0][2].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X')){
        return velha[1][1].getSimbolo();
    }

    return ' ';
}

}
