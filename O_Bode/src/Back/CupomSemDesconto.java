package Back;
public class CupomSemDesconto implements CupomIF{
    @Override
    public void setDesconto(Pedido p){
        p.setValor(p.calculaPrecoBruto());
    }
}
