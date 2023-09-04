package Front;
import Back.BlocoDeNotas;

public class Facade {

    BlocoDeNotas bn = new BlocoDeNotas();

    public void adicionarNota(String texto){
        bn.adicionar(texto);
    }

    public void removerNota(Integer id) throws Exception {
        bn.remover(id);
    }

    public void editarNota(String novoTexto, Integer id) throws Exception {
        bn.editar(novoTexto, id);
    }

    public String buscarNotasPorTrecho(String trecho) throws Exception {
        return bn.buscar(trecho);
    }

    public void recuperarNotaDaLixeira(Integer id) throws Exception {
        bn.recuperar(id);
    }

    public void esvaziarLixeira() throws Exception {
        bn.esvaziaLixeira();
    }

    public String mostrarBlocoDeNotas() throws Exception {
        return bn.retornarBloco();
    }

    public String mostrarLixeira() throws Exception {
        return bn.retornarLixeira();
    }

}