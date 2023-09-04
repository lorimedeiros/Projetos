package Back;
import java.util.ArrayList;

public class BlocoDeNotas {

    private ArrayList <Anotacao> suasAnotacoes = new ArrayList<>();
    private ArrayList <Anotacao> lixeira = new ArrayList<>();

    public void adicionar (String texto){

        if (texto == "" || texto == null) {
            throw new IllegalArgumentException("Texto vazio ou nulo");
        }

        Anotacao an = new Anotacao(texto, suasAnotacoes.size() + 1);
        suasAnotacoes.add(an);

    }

    public void remover(Integer id) throws Exception {

        if (suasAnotacoes.isEmpty()){
            throw new Exception("Bloco de notas vazio");
        }
        if ((id - 1) > suasAnotacoes.size()){
            throw new ArrayIndexOutOfBoundsException("Id inexistente");
        }

        Anotacao item = suasAnotacoes.get(id - 1);
        lixeira.add(item);
        suasAnotacoes.remove(item);

        for (int i = 0; i < suasAnotacoes.size(); i ++){

            Anotacao mod = suasAnotacoes.get(i);
            mod.setId(i + 1);

        }

    }

    public void editar(String texto, Integer id) throws Exception {

        if (suasAnotacoes.isEmpty()){
            throw new Exception("Bloco de notas vazio");
        }
        if ((id - 1) > suasAnotacoes.size()){
            throw new ArrayIndexOutOfBoundsException("Id inexistente");
        }
        if (texto == "" || texto == null){
            throw new IllegalArgumentException("Texto vazio ou nulo");
        }

        Anotacao item = suasAnotacoes.get(id - 1);
        item.setTexto(texto);

    }

    public String buscar(String trecho) throws Exception {

        if (suasAnotacoes.isEmpty()){
            throw new Exception("Bloco de notas vazio");
        }

        String achados = "";

        for (int i = 0; i < suasAnotacoes.size(); i++) {

            Anotacao an = suasAnotacoes.get(i);

            if (an.toString().contains(trecho)){

                achados += an.toString() + "\n\n";

            }

        }

        if (achados == "" || trecho == "") {
            return "Não foram encontradas notas com o trecho informado";
        } else {
            return achados;
        }

    }

    public void recuperar(Integer id) throws Exception {

        if (lixeira.isEmpty()){
            throw new Exception("Lixeira vazia");
        }
        if ((id - 1) > lixeira.size()){
            throw new ArrayIndexOutOfBoundsException("Id inexistente");
        }

        Anotacao an = lixeira.get(id - 1);
        suasAnotacoes.add(an);
        lixeira.remove(an);

        for (int i = 0; i < suasAnotacoes.size(); i ++){

            Anotacao mod = suasAnotacoes.get(i);
            mod.setId(i + 1);

        }

    }

    public void esvaziaLixeira() throws Exception {

        if (lixeira.isEmpty()){
            throw new Exception("Lixeira vazia");
        }

        for (int i = 0; i < lixeira.size(); i++) {
            Anotacao an = lixeira.get(i);
            lixeira.remove(an);
        }

    }

    public String retornarLixeira() throws Exception {

        if (lixeira.isEmpty()){
            throw new Exception("Lixeira vazia");
        }

        for (int i = 0; i < lixeira.size(); i++){
            Anotacao an = lixeira.get(i);
            System.out.println(an.toString());
            System.out.println();
        }

        return null;

    }

    public String retornarBloco() throws Exception {

        if (suasAnotacoes.isEmpty()){
            throw new Exception("Bloco de notas vazio");
        }

        for (int i = 0; i < suasAnotacoes.size(); i++){
            Anotacao an = suasAnotacoes.get(i);
            System.out.println(an.toString());
            System.out.println();
        }

        return null;

    }

    //outra solução apresentada para "retornarBloco(), que seria o "toString()" da classe Back.BlocoDeNotas"
    /*
    public String toString() {
        String str = "";
        for (Back.Anotacao an : suasAnotacoes) {
            str += (an.toString() + "\n");
        }
        return str;
    }
    */

}