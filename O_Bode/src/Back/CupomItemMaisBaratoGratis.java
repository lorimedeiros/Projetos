package Back;
public class CupomItemMaisBaratoGratis implements CupomIF{
    @Override
    public void setDesconto(Pedido p) {
        Double desconto = p.maisBarato().getPreco();
        p.setValor(p.calculaPrecoBruto() - desconto);
    }
}
