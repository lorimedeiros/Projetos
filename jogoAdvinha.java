import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
  Random ran = new Random();
  
  int num = ran.nextInt(100);

  int pontuacao = 100;
    
  boolean parada = false;
  
  while (!parada) {
   
    System.out.println("Informe seu palpite:");
    int palpite = Integer.parseInt(sc.nextLine());
    
    if(palpite == num){
      System.out.println("Você acertou!");
      System.out.println("Pontuação: " + pontuacao);
      parada = true;
      
    } else if((palpite > num) && (palpite < 101)) {
      System.out.println("O número sorteado é menor");
      System.out.println();
      pontuacao -=2;
      
    } else if((palpite) < num &&(palpite > -1)) {
      System.out.println("O número sorteado é maior");
      System.out.println();
      pontuacao -=2;
      
    } else if ((palpite < 0) || (palpite > 100)){
      System.out.println("Palpite inválido");
      System.out.println();
      
    }
    if (pontuacao <= 0){
      System.out.println("Você perdeu o jogo");
      parada = true;
    }
  }

  sc.close();
      
  }
}
