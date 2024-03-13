package Back;

import java.util.ArrayList;

public enum ProdutoDaLoja {

    BATATA_FRITA(8.0),
    PASTEL(10.0),
    CHOCOLATE_AO_LEITE(8.0),
    AGUA(3.0),
    REFRIGERANTE(4.0),
    PAO_BOLA(7.0),
    PORCAO_DE_QUEIJO(12.0),
    CARNE_HAMBURGUER(12.0),
    BATATA_COM_QUEIJO(20.75),
    HAMBURGUER(23.25),
    PASTEL_COM_REFRIGERANTE(10.50),
    CHOCOLATE_COM_AGUA(8.25);

    private double preco;
    private  int qt = 0;

    ProdutoDaLoja(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return ordinal();
    }

    public Integer getQt(){
        return qt;
    }

    public void aumentaQt(){
        qt += 1;
    }

    public void diminuiQt(){
        qt -= 1;
    }

    public void zeraQt(){
        qt = 0;
    }

    public String getDescricao() {
        return toString();
    }

}
