package Back;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pedido{

    DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");
    private ArrayList <ProdutoDaLoja> pedidos = new ArrayList<>();
    private LocalDateTime dataInicioPedido;
    private String dataInicioPedidoStr;
    private LocalDateTime dataFimPedido;
    private String dataFimPedidoStr;
    private Cliente cliente;
    private Status status;
    private CupomIF cupom;
    private Double valor;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.dataInicioPedido = LocalDateTime.now();
        this.dataInicioPedidoStr = LocalDateTime.now().format(f);
        this.status = Status.AGUARDANDO_PREPARO;
    }

    public String getCliente(){
        return cliente.getNome();
    }

    public void setCupom(){
        if (contaItens() == 4){
            this.cupom = new CupomPague3ELeve4Bode();
        } else if (contaItens() >= 5){
            this.cupom = new CupomItemMaisBaratoGratis();
        } else {
            this.cupom = new CupomSemDesconto();
        }
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public Double getValor(){
        cupom.setDesconto(this);
        return valor;
    }

    public void addItem(int i){
        List<ProdutoDaLoja> lista;
        lista = Arrays.stream(ProdutoDaLoja.values()).toList();
        ProdutoDaLoja p = lista.get(i -1);
        p.aumentaQt();
        pedidos.add(p);
    }

    public void cancelarPedido(Loja l){
        if (status == Status.AGUARDANDO_PREPARO){
            this.status = Status.CANCELADO_PELO_CLIENTE;
            this.dataFimPedido = LocalDateTime.now();
            this.dataFimPedidoStr = LocalDateTime.now().format(f);
            l.cancelar(this);
        }
    }

    public void finalizaMontagemDoPedido(Loja l){
        l.aguardaPreparo(this);
    }

    public void prepararPedido(){
        if (status == Status.AGUARDANDO_PREPARO){
            status = Status.EM_PREPARO;
        }
    }

    public void finalizaPedido(){
        if (status == Status.EM_PREPARO){
            this.status = Status.ENTREGUE;
            this.dataFimPedido = LocalDateTime.now();
            this.dataFimPedidoStr = LocalDateTime.now().format(f);
        }
    }

    public void removerItem(int i){
        ProdutoDaLoja p = pedidos.get(i - 1);
        p.diminuiQt();
        pedidos.remove(p);
    }

    public Double calculaPrecoBruto(){
        Double pb = 0.0;

        for (int i = 0; i < pedidos.size(); i++) {

            ProdutoDaLoja p = pedidos.get(i);
            pb += p.getPreco();

        }

        return pb;
    }

    public Integer contaItens(){
        return pedidos.size() + 1;
    }

    public ProdutoDaLoja maisBarato(){
        ProdutoDaLoja mb = pedidos.get(0);

        for (int i = 0; i < pedidos.size(); i++) {
            ProdutoDaLoja p = pedidos.get(i);
            if (p.getPreco() < mb.getPreco()){
                mb = p;
            }
        }

        return mb;
    }

    @Override
    public String toString(){
        String str = "";

        for (int i = 0; i < pedidos.size(); i++) {

            ProdutoDaLoja p = pedidos.get(i);
            str += (i+1) + ". " + p.getDescricao() + "\n";

        }

        return str;

    }

    public String pedidoFinal(){
        String str = "Pedido:\n";

        for (int i = 0; i < pedidos.size(); i++) {

            ProdutoDaLoja p = pedidos.get(i);
            str += (i+1) + ". " + p.getDescricao() + "\n";

        }

        this.setCupom();
        str += "\nHorário da venda: " + dataInicioPedidoStr + "\nTotal a pagar R$ " + this.valor;
        if (this.cupom instanceof CupomSemDesconto){
            str += "\nNenhum cupom pode ser aplicado";
        } else if (this.cupom instanceof CupomItemMaisBaratoGratis) {
            str += "\nCupom 'Item mais barato gratis' aplicado";
        } else {
            str += "\nCupom 'Pague 3 leve 4' aplicado";
        }
        return str;
    }

    public long tempoPreparoMinutos(){
        Duration t = Duration.between(dataInicioPedido, dataFimPedido);
        return t.toMinutes();
    }

}
