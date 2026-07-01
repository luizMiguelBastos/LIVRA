LIVRA — Sistema de Gerenciamento de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java puro, com foco em Programação Orientada a Objetos. Permite o cadastro e controle de usuários, acervo de livros e empréstimos com desconto automático por categoria de usuário.


Funcionalidades


Cadastro de usuários por categoria (Aluno, Professor, Usuário Comum)
Busca de usuários por ID
Cadastro de livros com valor de aluguel
Catálogo de livros disponíveis
Sistema de aluguel com controle de disponibilidade
Devolução de livros
Desconto automático por categoria:

Aluno: 10% de desconto
Professor: 20% de desconto
Usuário Comum: sem desconto






Conceitos de POO aplicados

ConceitoAplicaçãoHerançaAluno, Professor e UsuarioComum herdam de UsuarioPolimorfismoMétodo calcularDesconto() com comportamento diferente por tipoEncapsulamentoAtributos privados com getters/setters em todas as classesAbstraçãoModelagem de entidades do mundo real (Usuário, Livro)


Tecnologias


Linguagem: Java (JDK 11+)
IDE recomendada: IntelliJ IDEA
Dependências: Nenhuma — Java puro



Como rodar

Pré-requisitos


JDK 11 ou superior instalado
IntelliJ IDEA (recomendado) ou qualquer IDE Java


Pelo IntelliJ IDEA


Clone o repositório:


bashgit clone https://github.com/luizMiguelBastos/LIVRA.git


Abra o IntelliJ IDEA
Clique em File → Open e selecione a pasta do projeto
Aguarde o IntelliJ indexar o projeto
Localize o arquivo Main.java
Clique no botão de execução ao lado do método main


Pelo terminal

bash# Clone o repositório
git clone https://github.com/luizMiguelBastos/LIVRA.git
cd LIVRA/BibliotecaLivra/src

# Compile todos os arquivos
javac *.java

# Execute
java Main


Estrutura do Projeto

LIVRA/
└── BibliotecaLivra/
    └── src/
        ├── Main.java          # Ponto de entrada e menu principal
        ├── Usuario.java       # Classe base de usuário
        ├── Aluno.java         # Herda de Usuario — desconto de 10%
        ├── Professor.java     # Herda de Usuario — desconto de 20%
        ├── UsuarioComum.java  # Herda de Usuario — sem desconto
        └── Livro.java         # Entidade livro com controle de aluguel


Sobre o projeto

O LIVRA foi desenvolvido como projeto pessoal após a conclusão do primeiro semestre de Análise e Desenvolvimento de Sistemas e de um curso dedicado a Programação Orientada a Objetos. O objetivo foi consolidar na prática os principais pilares da POO em um sistema funcional com fluxo real de uso.


Autor

Luiz Miguel Bastos da Silva
LinkedIn: https://www.linkedin.com/in/luiz-miguel-bastos-64548b317/
