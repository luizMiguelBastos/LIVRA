import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        Usuario usuarios[] = new Usuario[20];
        int contadorUsuarios = 0;
        Livro livros[] = new Livro[20];
        int contadorLivros = 0;

        while (true) {
            System.out.println();
            System.out.println("Seja Bem vindo a Biblioteca LIVRA");
            System.out.println();
            System.out.println("O que você deseja?");
            System.out.println("1- Cadastar novo usuario." +
                    "\n2- Buscar usuario." +
                    "\n3- Cadastrar novo livro." +
                    "\n4- Catálogo de livros disponiveis. " +
                    "\n5- Alugar um livro." +
                    "\n6- Devolver um livro." +
                    "\n7- Sair");

            int entrada = scanner.nextInt();
            scanner.nextLine();
            while (entrada < 1 || entrada > 7){
                System.out.println("Digite um número válido!");
                entrada = scanner.nextInt();
                scanner.nextLine();
            }

            if (entrada == 1) {
                Usuario user = null;
                System.out.println("Escolha a categoria do Usuario:" +
                        "\n1- Aluno;" +
                        "\n2- Professor;" +
                        "\n3- Usuario comum;");
                int categoria = scanner.nextInt();
                scanner.nextLine();

                if (categoria == 1) {
                    System.out.println("Digite um nome para este usuario:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite um ID para este usuario:");
                    String id = scanner.nextLine();
                    user = new Aluno(nome, id);
                    System.out.println("Usuario criado com sucesso!");

                } else if (categoria == 2) {
                    System.out.println("Digite um nome para este usuario:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite um ID para este usuario:");
                    String id = scanner.nextLine();
                    user = new Professor(nome, id);
                    System.out.println("Usuario criado com sucesso!");

                } else if (categoria == 3){
                    System.out.println("Digite um nome para este usuario:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite um ID para este usuario:");
                    String id = scanner.nextLine();
                    user = new UsuarioComum(nome, id);
                    System.out.println("Usuario criado com sucesso!");
                } else {
                    System.out.println("Numero inválido, voltando para o menu principal.");
                }

                usuarios[contadorUsuarios] = user;
                contadorUsuarios++;
            }
            if (entrada == 2) {
                System.out.println("Por favor, digite o ID do usuario:");
                String idBusca = scanner.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contadorUsuarios; i++) {
                    if (usuarios[i].getId().equals(idBusca)) {
                        System.out.println(
                                "Usuario encontrado!" +
                                        "\nNome: " + usuarios[i].getNome() +
                                        "\nID: " + usuarios[i].getId()
                        );
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("ID não encontrado, voltando ao menu principal.");
                }
            }
            if (entrada == 3){
                System.out.println("Qual o nome do livro?");
                String nomeLivro = scanner.nextLine();

                System.out.println("Qual o Autor do livro?");
                String autorLivro = scanner.nextLine();

                System.out.println("Qual o ID do livro?");
                String idLivro = scanner.nextLine();

                System.out.println("Qual o valor do aluguel do livro?");
                double aluguelLivro = scanner.nextDouble();
                scanner.nextLine();

                Livro livro = new Livro (nomeLivro, autorLivro, idLivro, aluguelLivro);
                livros[contadorLivros] = livro;
                contadorLivros++;
            }
            if (entrada == 4){
                System.out.println("Nossos livros disponiveis são:");
                System.out.println();

                for (int i = 0; i < contadorLivros; i++){
                    System.out.println("Nome: " + livros[i].getNomeLivro() +
                            "\nAutor: " + livros[i].getAutorLivro() +
                            "\nID: " + livros[i].getIdLivro() +
                            "\nAluguel: " + "R$" + livros[i].getValorLivro());
                    System.out.println();
                }
            }
            if (entrada == 5) {
                System.out.println("Digite o NOME ou o ID do livro desejado: ");
                String busca = scanner.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contadorLivros; i++) {

                    if (livros[i].getIdLivro().equals(busca) ||
                            livros[i].getNomeLivro().equals(busca)) {
                        encontrado = true;

                        if (livros[i].isAlugado()) {
                            System.out.println("Esse livro já está alugado!");
                            break;
                        }

                        System.out.println("Encontramos o livro em nosso sistema, aqui estão suas informações: ");
                        System.out.println("Nome: " + livros[i].getNomeLivro() +
                                "\nAutor: " + livros[i].getAutorLivro() +
                                "\nID: " + livros[i].getIdLivro() +
                                "\nAluguel: R$" + livros[i].getValorLivro());
                        System.out.println();

                        System.out.println("Deseja alugar o livro " + livros[i].getNomeLivro() + "?" +
                                "\nDigite 1 para sim e 2 para não: ");
                        int desejaAlugar = scanner.nextInt();
                        scanner.nextLine();

                        if (desejaAlugar == 1) {
                            System.out.println("Digite seu ID: ");
                            String idUsuario = scanner.nextLine();

                            for (int j = 0; j < contadorUsuarios; j++) {
                                if (usuarios[j].getId().equals(idUsuario)) {
                                    double desconto = usuarios[j].calcularDesconto();
                                    double valorFinal = livros[i].getValorLivro()
                                            - (livros[i].getValorLivro() * desconto);
                                    usuarios[j].alugarLivro(livros[i]);
                                    System.out.println("Livro alugado com sucesso!");

                                    if (usuarios[j] instanceof Aluno) {
                                        System.out.println("Desconto aplicado: 10%");

                                    } else if (usuarios[j] instanceof Professor) {
                                        System.out.println("Desconto aplicado: 20%");

                                    } else {
                                        System.out.println("Sem desconto aplicado.");
                                    }

                                    System.out.println("Valor final: R$" + valorFinal);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Livro não encontrado no sistema, voltando ao menu principal.");
                }
            }
            if (entrada == 6){
                System.out.println("Qual o seu ID?");
                String idUsuairo = scanner.nextLine();
                for (int i = 0; i < contadorUsuarios; i++){
                    if (usuarios[i].getId().equals(idUsuairo) && usuarios[i].getLivroAlugado() !=null) {
                        System.out.println("Você gostaria de devolver o livro: " + usuarios[i].getLivroAlugado().getNomeLivro() + "?" +
                                "\n Digite 1 para sim e 2 para não" );
                        int verificacao = scanner.nextInt();
                        if (verificacao == 1){
                            usuarios[i].devolverLivro();
                            System.out.println("Livro devolvido com Sucesso!");
                        }
                    } break;
                }
            }
            if (entrada == 7){
                break;
            }
        }
    }
}
