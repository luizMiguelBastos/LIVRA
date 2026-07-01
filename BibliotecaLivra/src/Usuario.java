public class Usuario {

    private String nome;
    private String id;
    private Livro livroAlugado;

    public Usuario (String nome, String id){
        this.nome = nome;
        this.id = id;
        this.livroAlugado = null;
    }

    public String getNome() {
        return nome;
    }
    public String getId() {
        return id;
    }
    public Livro getLivroAlugado(){ return livroAlugado; }

    public void setNome(){this.nome = nome;}
    public void  setId(){this.id = id;}

    public double calcularDesconto(){
        return 0;
    }
    public void alugarLivro (Livro livro){
        this.livroAlugado = livro;
        livro.setAlugado(true);
    }
    public void devolverLivro(){
        livroAlugado.setAlugado(false);
        livroAlugado = null;
    }

}
