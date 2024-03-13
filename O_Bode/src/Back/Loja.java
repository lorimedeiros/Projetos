package Back;

import java.util.*;

public class Loja {

    private static Integer SENHA = 0000;
    private ArrayList <Pedido> pedidosFinalizados = new ArrayList<>();
    private ArrayList <Pedido> pedidosFinalizadosGeral = new ArrayList<>(); //aqui vai estar tudo + cancelados
    private ArrayList <Pedido> pedidosAguardandoPrep = new ArrayList<>();
    private ArrayList <Pedido> pedidosEmPrep = new ArrayList<>();

    public boolean verificaSenha(Integer tentativa){
        if (tentativa == this.SENHA){
            return true;
        } else {
            return false;
        }
    }

    public String mostraFinalizados(){
        String str = "";

        for (int i = 0; i < pedidosFinalizados.size(); i++) {

            Pedido p = pedidosFinalizados.get(i);
            str += "Pedido Nº " + i + 1 + "\nCliente: " + p.getCliente() + "\n" + p.toString() + "\n";

        }

        return str;
    }

    public String mostraAguardandoPrep(){
        String str = "";

        for (int i = 0; i < pedidosAguardandoPrep.size(); i++) {

            Pedido p = pedidosAguardandoPrep.get(i);
            str += "Prioridade: " + (i + 1) + "\n" + p.toString() + "\n";

        }

        return str;
    }

    public String mostraEmPrep(){
        String str = "";

        for (int i = 0; i < pedidosEmPrep.size(); i++) {

            Pedido p = pedidosEmPrep.get(i);
            str += "Prioridade: " + (i + 1) + "\n" + p.toString() + "\n";

        }

        return str;
    }

    public void preparar(int i){
        Pedido p = pedidosAguardandoPrep.get(i - 1);
        p.prepararPedido();
        pedidosAguardandoPrep.remove(p);
        pedidosEmPrep.add(p);
    }

    public void entregar(int i){
        Pedido p = pedidosEmPrep.get(i - 1);
        p.finalizaPedido();
        pedidosEmPrep.remove(p);
        pedidosFinalizados.add(p);
        pedidosFinalizadosGeral.add(p);
    }

    public void cancelar(Pedido p){
        pedidosFinalizadosGeral.add(p);
    }

    public void aguardaPreparo(Pedido p){
        pedidosAguardandoPrep.add(p);
    }

    public long tempoMedio(){
        long minutos = 0;
        for (int i = 0; i < pedidosFinalizados.size(); i++) {
            Pedido p = pedidosFinalizados.get(i);
            minutos += p.tempoPreparoMinutos();
        }
        return minutos / pedidosFinalizados.size();
    }

    public String pedidosEntreguesTempo(){
        String str = "";

        for (int i = 0; i < pedidosFinalizados.size(); i++) {
            Pedido p = pedidosFinalizados.get(i);
            str += p.pedidoFinal() + "\nTempo de preparo " + p.tempoPreparoMinutos() + "m\n";
        }

        str += "Tempo médio de espera do dia: " + tempoMedio() + "m";
        return str;
    }

    public String relatorioVendas(){
        String str = "";
        Double totalArrecadado = 0.0;

        for (int i = 0; i < pedidosFinalizados.size(); i++) {
            Pedido p = pedidosFinalizados.get(i);
            str += p.pedidoFinal() + "\n";
            totalArrecadado += p.getValor();
        }

        str += "Total arrecadado do dia R$ " + totalArrecadado;

        return str;
    }

    public String relatorioEstatisticas(){
        String str = "";

        List<ProdutoDaLoja> lista;
        lista = Arrays.stream(ProdutoDaLoja.values()).toList();
        ArrayList <ProdutoDaLoja> ordenada = new ArrayList<>();
        for (ProdutoDaLoja p: lista) {
            ordenada.add(p);
        }
        Comparator<ProdutoDaLoja> comp = Comparator.comparing(ProdutoDaLoja::getQt).reversed();
        Collections.sort(ordenada, comp);

        for (ProdutoDaLoja p : ordenada) {

            if(p.getQt() > 0) {
                str += "Produto: " + p.getDescricao() + " - vendas: " + p.getQt() + "\n";
            } else {
                str += "Produto: " + p.getDescricao() + " - NÃO VENDEU\n";
            }

        }

        return str;
    }

    public void fechaLoja(){
        List<ProdutoDaLoja> lista;
        lista = Arrays.stream(ProdutoDaLoja.values()).toList();

        for (ProdutoDaLoja p: lista) {
            p.zeraQt();
        }

        pedidosFinalizados.clear();
        pedidosFinalizadosGeral.clear();
        pedidosEmPrep.clear();
        pedidosAguardandoPrep.clear();

    }

    public String mostraCardapio(){
        String str = "";

        List<ProdutoDaLoja> lista;
        lista = Arrays.stream(ProdutoDaLoja.values()).toList();
        for (ProdutoDaLoja p: lista) {
            str += (p.getCodigo() + 1) + " " + p.getDescricao() + " - R$" + p.getPreco() + "\n";
        }

        return str;
    }

}
