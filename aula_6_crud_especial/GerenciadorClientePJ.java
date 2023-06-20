import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorClientePJ {
    Scanner scanner;
    DaoClientePJ daoClientePJ;

    public GerenciadorClientePJ(){
        scanner = new Scanner(System.in);
        daoClientePJ = new DaoClientePJ();
    }


    public void menu() throws NumberFormatException, Exception{
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("--- Gerenciador de clientes PJ ---");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar todos");
            System.out.println("[6] Voltar");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    this.cadastrarClientePJ(); 
                    break;
                case 2:
                    this.buscarUm();
                    break;
                case 3:
                    this.alterarCliPJ();
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

    public void cadastrarClientePJ() {
        ClientePJ cPj = new ClientePJ();
        System.out.println("---------------");
        System.out.println("Cadastro de clientes PJ");
        System.out.print("Nome: ");
        cPj.setNome(scanner.nextLine());
        System.out.println();
        System.out.print("CNPJ: ");
        cPj.setCnpj(scanner.nextLine());
        System.out.println();
        
        EnderecoPJ ePj = new EnderecoPJ();
        System.out.print("Rua: ");
        ePj.setRua(scanner.nextLine());
        System.out.println();
        System.out.print("Numero: ");
        ePj.setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.println();
        System.out.print("Bairro: ");
        ePj.setBairro(scanner.nextLine());
        System.out.println();
        System.out.print("CEP: ");
        ePj.setCep(scanner.nextLine());
        System.out.println();
        cPj.setEnderecoPJ(ePj);
        
        boolean inserido = daoClientePJ.inserir(cPj);
        if (inserido) {
            System.out.println("Inserido com sucesso.");
        }
    }

    public void listarTodos() {
        ArrayList<ClientePJ> result = daoClientePJ.BuscarTodos();

        System.out.println("--- Lista de veículos ---");
        for (ClientePJ cPj: result){
            System.out.println("");
            System.out.println("--- Cliente CNPJ: " + cPj.getCnpj());

            System.out.println("Numero: " + cPj.getCodigoclientepj());
            System.out.println("Nome: " + cPj.getNome());

            EnderecoPJ end = cPj.getEnderecoPJ();

            System.out.println("Rua: " + end.getRua());
            System.out.println("Numero: " + end.getNumero());
            System.out.println("Bairro: " + end.getBairro());
            System.out.println("CEP: " + end.getCep());
            
        }
        
    }

    public void excluir() {
        System.out.println("--- Exclusão ---");
        System.out.print("Código > ");
        int codigo = Integer.parseInt(scanner.nextLine());
        
        int resultado = daoClientePJ.excluir(codigo);

        if (resultado > 0) {
            System.out.println("Excluído.");
        }
        else {
            System.out.println("Não encontrado.");
        }

    }

    public void buscarUm() {
        System.out.println("--- Pesquisar ---");
        System.out.print("Código > ");

        int codigo = Integer.parseInt(scanner.nextLine());

        ClientePJ cPj = daoClientePJ.BuscarUm(codigo);
        if (cPj != null){
            System.out.println("... Encontrado!");
            System.out.println("--- Cliente: " + cPj.getCodigoclientepj());
            System.out.println("Nome: " + cPj.getNome());
            System.out.println("CNPJ: " + cPj.getCnpj());
            System.out.println("Rua: " + cPj.getEnderecoPJ().getRua());
            System.out.println("Numero: " + cPj.getEnderecoPJ().getNumero());
            System.out.println("Bairro: " + cPj.getEnderecoPJ().getBairro());
            System.out.println("CEP: " + cPj.getEnderecoPJ().getCep());

        }
        else {
            System.out.println("Não encontrado");
        }
    }

    public void alterarCliPJ() {
        ClientePJ cPj = new ClientePJ();
        System.out.println("---------------");
        System.out.print("Código do cliente > ");
        int codigo = Integer.parseInt(scanner.nextLine());

        cPj = daoClientePJ.BuscarUm(codigo);

        if(cPj!= null){
            System.out.println("Dados do Cliente: ");
            System.out.println("Nome: " + cPj.getCodigoclientepj());
            System.out.println("Alterar nome (vazio para manter): ");
            // funções boas pra usar em inputs e teste se é vazio
            String nome = scanner.nextLine().trim();
            if (!nome.isEmpty()){
                cPj.setNome(nome);
            }

            System.out.println("CNPJ: " + cPj.getCnpj());
            System.out.println("Novo CNPJ (vazio para manter): ");
            String cnpj = scanner.nextLine();
            if (cnpj!=""){
                cPj.setCnpj(cnpj);
            }

            System.out.println("Rua: " + cPj.getEnderecoPJ().getRua());
            System.out.println("Nova numero (vazio para manter): ");
            String rua = scanner.nextLine();
            if (rua!=""){
                cPj.getEnderecoPJ().setRua(rua);
            }

            System.out.println("Número: " + cPj.getEnderecoPJ().getNumero());
            System.out.println("Número (vazio para manter): ");
            Integer numero = Integer.parseInt(scanner.nextLine());
            if(numero!=null){
                cPj.getEnderecoPJ().setNumero(numero);
            }

            System.out.println("Bairro: " + cPj.getEnderecoPJ().getBairro());
            System.out.println("Novo bairro (vazio para manter): ");
            String bairro = scanner.nextLine();
            if (bairro!=""){
                cPj.getEnderecoPJ().setBairro(bairro);
            }

            System.out.println("Bairro: " + cPj.getEnderecoPJ().getCep());
            System.out.println("CEP (vazio para manter): ");
            String cep = scanner.nextLine();
            if (cep!=""){
                cPj.getEnderecoPJ().setCep(cep);
            }

        }    
        
        boolean alterado = daoClientePJ.alterar(cPj);
        if (alterado) {
            System.out.println("Alterado com sucesso.");
        }
    }

}
