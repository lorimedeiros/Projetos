import java.text.DateFormat;
public class Anotacao {

    private String titulo;
    private String conteudo;
    private String data;

    public void Anotacao(String titulo, String conteudo){
        this.titulo = titulo;
        this.conteudo = conteudo;

        DateFormat hora = DateFormat.getTimeInstance();
        String dt = String.valueOf(hora.format(data));
        this.data = dt;

        String antLindinha = "Título: " + getTitulo() + "\n" + getConteudo() + "\n" + "Data: " + getData();
        BlocoDeNotas.anotacoes.add(antLindinha);
    }

    public String getTitulo(){
        return titulo;
    }

    public String getConteudo(){
        return conteudo;
    }

    public String getData(){
        return data;
    }

    public void setTitulo(String novoTitulo){
        titulo = novoTitulo;
        DateFormat hora = DateFormat.getTimeInstance();
        String dt = String.valueOf(hora.format(data));
        data = dt;
    }

    public void setConteudo(String novoConteudo){
        conteudo = novoConteudo;
        DateFormat hora = DateFormat.getTimeInstance();
        String dt = String.valueOf(hora.format(data));
        data = dt;
    }

}
