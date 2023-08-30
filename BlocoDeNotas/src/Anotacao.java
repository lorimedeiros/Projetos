package Back;

import java.time.LocalDate;

public class Anotacao {

    private String texto;
    private LocalDate dataDeCriacao;
    private Integer id;


    public Anotacao(String texto, Integer id){

        this.texto = texto;
        this.dataDeCriacao = LocalDate.now();
        this.id = id;

    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

    public LocalDate getDataDeCriacao(){
        return dataDeCriacao;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setIdRemovido(Integer novoId){
        id = novoId;
    }

    public String toString(){

        return "Anotação " + getId() + ":\n" + getTexto() + "\n" + getDataDeCriacao();

    }

}
