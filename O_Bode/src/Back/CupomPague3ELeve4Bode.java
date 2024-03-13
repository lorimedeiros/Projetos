package Back;
public class CupomPague3ELeve4Bode implements CupomIF{
    @Override
    public void setDesconto(Pedido p) {
        Double desconto = p.maisBarato().getPreco();
        p.setValor(p.calculaPrecoBruto() - desconto);
    }
}
