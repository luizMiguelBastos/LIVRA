public class Livro {

    private String nomeLivro;
    private String autorLivro;
    private String idLivro;
    private double valorLivro;
    private boolean alugado;

    public Livro (String nomeLivro, String autorLivro,String idLivro, double valorLivro){
        this.nomeLivro = nomeLivro;
        this.autorLivro = autorLivro;
        this.idLivro = idLivro;
        this.valorLivro = valorLivro;
        this.alugado = false;
    }

    public String getNomeLivro(){return nomeLivro;}
    public String getAutorLivro(){return autorLivro;}
    public String getIdLivro() {return idLivro;}
    public double getValorLivro(){return valorLivro;}


    public void setNomeLivro(){this.nomeLivro = nomeLivro;}
    public void setAutorLivro(){this.autorLivro = autorLivro;}
    public void setIdLivro(String idLivro) {this.idLivro = idLivro;}
    public void setValorLivro(){this.valorLivro = valorLivro;}

    public boolean isAlugado(){return alugado;}
    public void setAlugado(boolean alugado){
        this.alugado = alugado;
    }

}


