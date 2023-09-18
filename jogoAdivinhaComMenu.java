import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        int num = ran.nextInt(101);

        int pontuacao = 100;

        System.out.println("Selecione uma dificuldade:\n 1. Fácil\n 2. Mediana\n 3. Difícil\n 4. Dark Souls");
        int decre = 0;

        boolean parada1 = false;

        while(!parada1) {
            int dif = Integer.parseInt(sc.nextLine());
            if (dif == 1) {
                decre = 2;
                parada1 = true;
            } else if (dif == 2) {
                decre = 5;
                parada1 = true;
            } else if (dif == 3) {
                decre = 10;
                parada1 = true;
            } else if (dif == 4) {
                decre = 20;
                parada1 = true;
            } else {
                System.out.println("Presta atenção nas opções, seu jumento >:(");
            }
        }
        boolean parada2 = false;

        while (!parada2) {

            System.out.println("Informe seu palpite:");
            int palpite = Integer.parseInt(sc.nextLine());

            if(palpite == num){
                System.out.println("Você acertou!");
                System.out.println("Pontuação: " + pontuacao);
                parada2 = true;

            } else if((palpite > num) && (palpite < 101)) {
                System.out.println("O número sorteado é menor");
                System.out.println();
                pontuacao -= decre;

            } else if((palpite) < num &&(palpite > -1)) {
                System.out.println("O número sorteado é maior");
                System.out.println();
                pontuacao -= decre;

            } else if ((palpite < 0) || (palpite > 100)){
                System.out.println("Palpite inválido");
                System.out.println();

            }
            if (pontuacao <= 0){
                System.out.println("Você perdeu o jogo");
                System.out.println("O número era " + num);
                parada2 = true;
            }
        }

        sc.close();

    }
}
