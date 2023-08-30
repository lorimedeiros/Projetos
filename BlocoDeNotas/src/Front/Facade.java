package Front;

import Back.BlocoDeNotas;

public class Facade {

    BlocoDeNotas bn = new BlocoDeNotas();

    public void adicionarNota(String texto){
        bn.adicionar(texto);
    }

    public void removerNota(Integer id){
        bn.remover(id);
    }

    public void editarNota(String novoTexto, Integer id){
        bn.editar(novoTexto, id);
    }

    public String buscarNotasPorTrecho(String trecho){
        return bn.buscar(trecho);
    }

    public void recuperarNotaDaLixeira(Integer id){
        bn.recuperar(id);
    }

    public String mostrarBlocoDeNotas(){
        return bn.retornarBloco();
    }

    public String mostrarLixeira(){
        return bn.retornarLixeira();
    }

}
