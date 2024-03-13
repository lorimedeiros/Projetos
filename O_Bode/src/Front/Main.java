package Front;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Facade f = new Facade();
        Scanner sc = new Scanner(System.in);
        boolean parada = false;
        boolean parada2 = false;
        boolean parada3 = false;
        boolean parada4 = false;
        boolean parada5 = false;
        boolean parada6 = false;

        String caminhoDoArquivoCriar = "C:\\Users\\Lori\\Desktop\\teste.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDoArquivoCriar));

        System.out.println("Bem vindo ao Bode!");

        try (sc; bw){
            do {

                parada = false;
                System.out.println("Selecione como deseja acessar o sistema:\n1.Cliente\n2.Funcionário");
                int e = Integer.parseInt(sc.nextLine());

                if (e == 1) { //Cliente

                    do {

                        parada2 = false;
                        System.out.println("Menu cliente");
                        System.out.println("1.Iniciar pedido\n2.Voltar");
                        int e2 = Integer.parseInt(sc.nextLine());

                        if (e2 == 1) { //Pedido

                            System.out.println("Informe o nome do cliente:");
                            String nome = sc.nextLine();
                            f.criaCliente(nome);

                            System.out.println(f.mostraCardapio());

                            System.out.println("Informe o código do item que deseja pedir:");
                            int codPedido = Integer.parseInt(sc.nextLine());
                            f.adicionaItemAoPedido(codPedido);

                            do {
                                parada3 = false;
                                System.out.println("Deseja adicionar mais itens?\n1.Sim\n2.Finalizar pedido\n3.Remoção de item\n4.Cancelar pedido");
                                int e3 = Integer.parseInt(sc.nextLine());

                                if (e3 == 1) {
                                    System.out.println("Informe o código do item que deseja pedir:");
                                    codPedido = Integer.parseInt(sc.nextLine());
                                    f.adicionaItemAoPedido(codPedido);

                                } else if (e3 == 2) {
                                    f.aplicaCupom();
                                    f.mostraPedidoFinal();
                                    System.out.println("Confirmar finalização do pedido?\n1.sim\nQualquer outro numero para voltar");
                                    int conf = Integer.parseInt(sc.nextLine());

                                    if (conf == 1) {
                                        f.finalizaMontagemPedido();
                                        System.out.println("Pedido finalizado com sucesso!");
                                        parada2 = true;
                                        parada3 = true;
                                    }

                                } else if (e3 == 3) {
                                    f.mostraItensNoPedido();
                                    System.out.println("Informe o código do item que deseja remover:");
                                    codPedido = Integer.parseInt(sc.nextLine());
                                    System.out.println("Confirmar remoção do item?\n1.sim\nQualquer outro numero para voltar");
                                    int conf = Integer.parseInt(sc.nextLine());

                                    if (conf == 1) {
                                        f.removeItemDoPedido(codPedido);
                                    }

                                } else if (e3 == 4) {
                                    System.out.println("Confirmar cancelamento do pedido?\n1.sim\nQualquer outro numero para voltar");
                                    int conf = Integer.parseInt(sc.nextLine());

                                    if (conf == 1) {
                                        f.cancelaPedido();
                                        System.out.println("Pedido cancelado com sucesso!");
                                        parada3 = true;
                                        parada2 = true;
                                    }

                                } else {
                                    System.out.println("Opção inválida. Tente novamente!");
                                }

                            } while (!parada3);


                        } else if (e2 == 2) { //Voltar
                            parada2 = true;
                            System.out.println();
                        } else { //erro
                            System.out.println("Opção inválida. Tente novamente!");
                            System.out.println();
                        }
                    } while (!parada2);

                } else if (e == 2) { //Funcionário

                    System.out.println("Insira a senha de acesso:");
                    int senha = Integer.parseInt(sc.nextLine());

                    if (f.verificaSenha(senha)) {

                        do {
                            parada4 = false;
                            System.out.println("Menu funcionário");
                            System.out.println("1.Realizar serviços\n2.Solicitar relatório\n3.Encerrar atendimento do dia\nQualquer outro número para voltar");
                            int o = Integer.parseInt(sc.nextLine());

                            if (o == 1) {

                                do {
                                    parada6 = false;
                                    System.out.println("Informe o serviço que deseja realizar:");
                                    System.out.println("1.Preparar pedido\n2.Entregar pedido\nQualquer outro número para voltar");

                                    o = Integer.parseInt(sc.nextLine());
                                    if (o == 1) {
                                        System.out.println(f.pedidosAguardandoPrep());
                                        System.out.println("Informe o código do pedido que deseja preparar:");
                                        o = Integer.parseInt(sc.nextLine());
                                        f.preparaPedido(o);
                                        System.out.println("Pedido preparado com sucesso");
                                    } else if (o == 2) {
                                        System.out.println(f.pedidosEmPrep());
                                        System.out.println("Informe o código do pedido que deseja entregar:");
                                        o = Integer.parseInt(sc.nextLine());
                                        f.entregaPedido(o);
                                        System.out.println("Pedido entregue com sucesso");
                                    } else {
                                        parada6 = true;
                                    }
                                } while (!parada6);

                            } else if (o == 2) {

                                do {
                                    parada5 = false;
                                    System.out.println("Informe relatório a solicitar:");
                                    System.out.println("1.Relatório de vendas\n2.Relatório de tempo\n3.Relatório com estatística\nQualquer outro número para voltar");

                                    o = Integer.parseInt(sc.nextLine());
                                    if (o == 1) {
                                        f.relatorioVendas();
                                        System.out.println(f.relatorioVendas());
                                    } else if (o == 2) {
                                        System.out.println(f.relatorioTempo());
                                    } else if (o == 3) {
                                        System.out.println(f.relatorioEstatisticas());
                                    } else {
                                        parada5 = true;
                                    }
                                } while (!parada5);

                            } else if (o == 3) {
                                String[] linhas = new String[] {f.relatorioVendas(), f.relatorioTempo(), f.relatorioEstatisticas()};

                                Calendar c = Calendar.getInstance();
                                Date d = c.getTime();
                                DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);
                                bw.write("Data: " + fmt.format(d));
                                bw.newLine();
                                for (String linha: linhas) {
                                    bw.write(linha);
                                    bw.newLine();
                                }
                                f.encerraAtendimento();
                                parada4 = true;
                                parada = true;
                            } else {
                                parada4 = true;
                            }
                        } while (!parada4);

                    } else {
                        System.out.println("Senha incorreta");
                    }

                } else { //erro
                    System.out.println("Opção inválida. Tente novamente!");
                }
            } while (!parada);
        } catch (IOException | IllegalArgumentException | IndexOutOfBoundsException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}