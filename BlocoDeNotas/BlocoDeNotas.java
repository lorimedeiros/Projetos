import java.util.ArrayList;

public class BlocoDeNotas {
    static ArrayList <String> anotacoes = new ArrayList<>();

    public int mostraNumAnt(){
        return anotacoes.size();
    }

    public String verAnt(int numero){
        return anotacoes.get(numero);
    }

}
