public class Aluno extends Usuario {

    public Aluno (String nome, String id){
        super (nome, id);
    }

    @Override
    public double calcularDesconto(){
        return 0.10;
    }
}
