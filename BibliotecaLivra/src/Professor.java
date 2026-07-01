public class Professor extends Usuario{

    public Professor (String nome, String id){
        super(nome, id);
    }

    @Override
    public double calcularDesconto(){
        return 0.20;
    }
}
