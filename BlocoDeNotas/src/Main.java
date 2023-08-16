import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BlocoDeNotas bn = new BlocoDeNotas();
        Boolean parada = false;

        System.out.println("Bem vindo ao seu bloco de notas!");
        System.out.println();

        do {

            System.out.println("Menu:\n" +
                    "1. Adicionar nota\n" +
                    "2. Ver bloco de Notas\n" +
                    "3. Editar nota\n" +
                    "4. Excluir nota\n" +
                    "5. Ver lixeira\n" +
                    "6. Recuperar nota\n" +
                    "7. Sair");

            int respMenu = Integer.parseInt(sc.nextLine());
            System.out.println();

            if ((respMenu < 1) || (respMenu > 7)){
                System.out.println("Opção inexistente");
                System.out.println();
            }

            if (respMenu == 1){

                System.out.println("Insira conteúdo da nota");
                String cn = sc.nextLine();
                bn.adicionar(cn);

            } else if (respMenu == 2){

                bn.retornarBloco();

            } else if (respMenu == 3){

                System.out.println("Insira o ID da nota que deseja editar:");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Insira o novo conteúdo da nota:");
                String cont = sc.nextLine();
                bn.editar(cont, id);

            } else if (respMenu == 4){

                System.out.println("Insira o ID da nota que deseja excluir:");
                int id = Integer.parseInt(sc.nextLine());
                bn.remover(id);

            } else if (respMenu == 5){

                bn.retornarLixeira();

            } else if (respMenu == 6){

                System.out.println("Insira o ID, na lixeira, da nota que deseja recuperar:");
                int id = Integer.parseInt(sc.nextLine());
                bn.recuperar(id);

            } else if (respMenu == 7){

                parada = true;

            }

        } while(!parada);

        sc.close();

    }
}
