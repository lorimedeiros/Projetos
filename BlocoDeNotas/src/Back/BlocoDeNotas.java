package Back;

import Back.Anotacao;

import java.util.ArrayList;

public class BlocoDeNotas {

    private ArrayList <Anotacao> suasAnotacoes = new ArrayList<>();
    private ArrayList <Anotacao> lixeira = new ArrayList<>();

    public void adicionar (String texto){

        Anotacao an = new Anotacao(texto, suasAnotacoes.size() + 1);
        suasAnotacoes.add(an);

    }

    public void remover(Integer id){

        Anotacao item = suasAnotacoes.get(id - 1);
        lixeira.add(item);
        suasAnotacoes.remove(item);
        item.setIdRemovido(lixeira.size() + 1);

        for (int i = 0; i < suasAnotacoes.size(); i ++){

            Anotacao mod = suasAnotacoes.get(i);
            mod.setId(i + 1);

        }

    }

    public void editar(String texto, Integer id){

        Anotacao item = suasAnotacoes.get(id - 1);
        item.setTexto(texto);

    }

    public String buscar(String trecho){

        String achados = "";

        for (int i = 0; i < suasAnotacoes.size(); i++) {

            Anotacao an = suasAnotacoes.get(i);

            if (an.toString().contains(trecho)){

                achados += an.toString() + "\n\n";

            }

        }

        return achados;

    }

    public void recuperar(Integer id){

        Anotacao an = lixeira.get(id - 1);
        suasAnotacoes.add(an);
        lixeira.remove(an);

        for (int i = 0; i < suasAnotacoes.size(); i ++){

            Anotacao mod = suasAnotacoes.get(i);
            mod.setId(i + 1);

        }

    }

    public String retornarLixeira(){

        for (int i = 0; i < lixeira.size(); i++){

            Anotacao mod = lixeira.get(i);
            mod.setId(i + 1);

        }

        for (int i = 0; i < lixeira.size(); i++){
            Anotacao an = lixeira.get(i);
            System.out.println(an.toString());
            System.out.println();
        }

        return null;

    }

    public String retornarBloco(){

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