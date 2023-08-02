//lembrar de importar o jar do banco se quiser rodar

/*
Escreva um programa chamado CaixaChatBot.

Este chatbot deve ter as seguintes opções de uso:

1. para criar uma nova conta

2. para localizar uma conta já existente através de seu número

Com a conta identificada o menu de opções do bot deve mudar o menu para as seguintes opções:

    1. Depositar

    2. Sacar

    3. Extrato

    4. Transferir 

    5. Saldo

    6. Sair

Realize o desejo do usuário e em seguida, se a opção não é a de sair, apresente o menu novamente. Para cada opção é preciso solicitar do usuário os dados necessários para a operação.  Se o usuário quer sacar, pergunte quanto e saque... Se quer transferir pergunte para que conta (número) e o valor...

Fique neste loop até que o usuário deseje sair do programa. Antes de terminar o programa imprima o saldo final da conta.
*/

import banco.entidades.Agencia;
import banco.entidades.ContaSimples;
import banco.entidades.util.RecebeDados;

import java.util.Scanner;
import static banco.entidades.Agencia.localizarConta;

public class Main {
    public static void main(String[] args) {

        ContaSimples cs = null;
        Scanner sc = new Scanner(System.in);

        boolean parada1 = false;
        boolean parada2 = false;
        boolean parada3 = false;
        int respMenu1, respMenu2;


        do {

            //parada1

            System.out.println();
            System.out.println("1. Criar uma nova conta");
            System.out.println("2. Localizar uma conta já existente através de seu número");
            respMenu1 = Integer.parseInt(sc.nextLine());

            if ((respMenu1 != 1) && (respMenu1 != 2)){
                System.out.println("Opção inválida, tente novamente");
            }


            if (respMenu1 == 1){

                System.out.println();
                System.out.printf("Informe o nome do titular da conta: ");
                String nt = sc.nextLine();
                System.out.printf("Informe o CPF do titular da conta: ");
                String ct = sc.nextLine();
                cs = new ContaSimples(nt, ct);
                Agencia.addConta(cs);
                System.out.println("Dados da sua conta:");
                System.out.println(cs.toString());

            } else if (respMenu1 == 2){

                do {

                    //parada2

                    while(!parada3) {

                        //parada3

                        System.out.printf("Informe o número da conta: ");
                        long contaLocalizar = Long.parseLong(sc.nextLine());

                        if (localizarConta(contaLocalizar) == null) {

                            System.out.println();
                            System.out.println("Conta não localizada, tente novamente");
                            System.out.println();

                        } else {

                            System.out.println(Agencia.localizarConta(contaLocalizar).toString());
                            parada3 = true;

                        }

                    }


                    System.out.println();
                    System.out.println("1. Depositar");
                    System.out.println("2. Sacar");
                    System.out.println("3. Extrato");
                    System.out.println("4. Transferir");
                    System.out.println("5. Saldo");
                    System.out.println("6. Sair");
                    respMenu2 = Integer.parseInt(sc.nextLine());

                    if ((respMenu2 != 1) && (respMenu2 != 2) && (respMenu2 != 3) && (respMenu2 != 4) && (respMenu2 != 5) && (respMenu2 != 6)) {
                        System.out.println("Opção inválida, tente novamente");
                    }


                    if (respMenu2 == 1){

                        System.out.println();
                        double dep = RecebeDados.recebeValorMaiorQueZero("Informe a quantia que deseja depositar: ");
                        cs.depositar(dep);
                        System.out.println("Deposito realizado");

                    } else if (respMenu2 == 2){

                        System.out.println();
                        double sac = RecebeDados.recebeValorMaiorQueZero("Informe a quantia que deseja sacar: ");
                        cs.sacar(sac);
                        System.out.println("Saque realizado");

                    } else if (respMenu2 == 3){

                        if (cs.getMovimento() == null){

                            System.out.println();
                            System.out.println("Extrato indisponível");

                        } else {

                            System.out.println(cs.getMovimento());
                            //consertar, ta retornando endereço de obj

                        }


                    } else if (respMenu2 == 4){

                        System.out.printf("Informe o número da conta do destinatário: ");
                        long numDest = Long.parseLong(sc.nextLine());

                        if (localizarConta(numDest) == null) {

                            System.out.println("Conta não localizada");

                        } else {

                            System.out.printf("Informe o valor que deseja transferir: ");
                            double valorTransf = Double.parseDouble(sc.nextLine());

                            //botar mensagem de erro caso saldo indisponivel

                            cs.transferir(localizarConta(numDest), valorTransf);

                            //so mandar isso caso tenha saldo
                            System.out.println("Transferencia realizada");

                        }

                    } else if (respMenu2 == 5){

                        System.out.printf("Saldo da conta: ");
                        System.out.println(cs.getSaldo());

                    } else if (respMenu2 == 6){

                        System.out.printf("Saldo da conta: ");
                        System.out.println(cs.getSaldo());
                        parada2 = true;

                    }

                } while(!parada2);

                parada1 = true;
            }

        } while(!parada1);

        sc.close();

    }
}