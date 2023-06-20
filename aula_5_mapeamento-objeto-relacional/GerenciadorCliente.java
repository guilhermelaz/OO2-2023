import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCliente {
    Scanner scanner;
    DaoCliente daoCliente;

    public GerenciadorCliente() {
        scanner = new Scanner(System.in);
        daoCliente = new DaoCliente();  
    }

    public void menu() throws NumberFormatException, Exception{
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("--- Gerenciador de Clientes ---");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar todos");
            System.out.println("[6] Voltar");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    this.cadastrarCliente(); 
                    break;
                case 2:
                    this.buscarUm();
                    break;
                case 3:
                    this.alterarCliente();
                    break;
                case 4:
                    this.excluir();
                    break;
                case 5:
                    this.listarTodos();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Escolha uma opção da lista.");
            }
        }
    }


    public void cadastrarCliente() {
        Cliente c = new Cliente();
        System.out.println("---------------");
        System.out.println("Cadastro de clientes");
        System.out.print("Primeiro nome: ");
        c.setPrimeiro_nome(scanner.nextLine());
        System.out.println();

        System.out.print("Ultimo nome: ");
        c.setUltimo_nome(scanner.nextLine());
        System.out.println();

        System.out.print("CPF: ");
        c.setCpf(scanner.nextLine());
        System.out.println();

        System.out.print("Idade: ");
        c.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.println();

        boolean ok = daoCliente.inserir(c);
        if (ok) {
            System.out.println("Inserido com sucesso.");
        }
    }


    public void buscarUm() {
        System.out.println("--- Pesquisar ---");
        System.out.print("Código > ");

        int codigo = Integer.parseInt(scanner.nextLine());

        Cliente c = daoCliente.BuscarUm(codigo);
        if (c != null){
            System.out.println("... Encontrado!");
            System.out.println("--- Cliente: " + c.getCodigo());
            System.out.println("Nome: " + c.getPrimeiro_nome() + " " + c.getUltimo_nome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Idade: " + c.getIdade());
        }
        else {
            System.out.println("Não encontrado");
        }
    }


    public void alterarCliente() {
        Cliente c = new Cliente();
        System.out.println("---------------");
        System.out.print("Selecione o cliente para alterar > ");
        int codigo = Integer.parseInt(scanner.nextLine());

        c = daoCliente.BuscarUm(codigo);

        if(c!= null){
            System.out.println("Dados do cliente: ");
            System.out.println("Cliente: " + c.getCodigo());
            System.out.println("Primeiro nome: " + c.getPrimeiro_nome());
            System.out.println("Atualizar para (vazio para manter): ");
            String primeiro_nome = scanner.nextLine();
            if (primeiro_nome!=""){
                c.setPrimeiro_nome(primeiro_nome);
            }

            System.out.println("Ultimo nome: " + c.getUltimo_nome());
            System.out.println("Atualizar para (vazio para manter): ");
            String ultimo_nome = scanner.nextLine();
            if (ultimo_nome!=""){
                c.setUltimo_nome(ultimo_nome);
            }

            System.out.println("CPF: " + c.getCpf());
            System.out.println("Atualizar para (vazio para manter): ");
            String cpf = scanner.nextLine();
            if (cpf!=""){
                c.setCpf(cpf);
            }

            System.out.println("Idade: " + c.getIdade());
            System.out.println("Nova idade (vazio para manter): ");
            String idade = scanner.nextLine();
            if (idade!=""){
                int idadeInt = Integer.parseInt(idade);
                c.setIdade(idadeInt);
            }

        }    
        
        boolean alterado = daoCliente.alterar(codigo, c);
        if (alterado) {
            System.out.println("Alterado com sucesso.");
        }
    }

    public void excluir() {
        System.out.println("--- Exclusão ---");
        System.out.print("Código > ");
        int codigo = Integer.parseInt(scanner.nextLine());
        
        int resultado = daoCliente.excluir(codigo);

        if (resultado > 0) {
            System.out.println("Excluído.");
        }
        else {
            System.out.println("Não encontrado.");
        }

    }

    public void listarTodos() {
        ArrayList<Cliente> result = daoCliente.BuscarTodos();

        System.out.println("--- Lista de clientes ---");
        for (Cliente c: result){
            System.out.println("");
            System.out.println("--- Cliente: " + c.getCodigo());
            System.out.println("Nome: " + c.getPrimeiro_nome() + " " + c.getUltimo_nome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Idade: " + c.getIdade());
        }
        
    }


}
