import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo {
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }


    public void menu() throws NumberFormatException, Exception{
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("--- Gerenciador de veículos ---");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar todos");
            System.out.println("[6] Voltar");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    this.cadastrarVeiculo(); 
                    break;
                case 2:
                    this.buscarUm();
                    break;
                case 3:
                    this.alterarVeiculo();
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

    public void cadastrarVeiculo() {
        Veiculo v = new Veiculo();
        System.out.println("---------------");
        System.out.println("Cadastro de veículos");
        System.out.print("Marca: ");
        v.setMarca(scanner.nextLine());
        System.out.println();
        System.out.print("Modelo: ");
        v.setModelo(scanner.nextLine());
        System.out.println();
        System.out.print("Ano: ");
        v.setAno(Integer.parseInt(scanner.nextLine()));
        System.out.println();
        System.out.print("Chassi: ");
        v.setChassi(scanner.nextLine());
        System.out.println();
        
        boolean inserido = daoVeiculo.inserir(v);
        if (inserido) {
            System.out.println("Inserido com sucesso.");
        }
    }

    public void listarTodos() {
        ArrayList<Veiculo> result = daoVeiculo.BuscarTodos();

        System.out.println("--- Lista de veículos ---");
        for (Veiculo v: result){
            System.out.println("");
            System.out.println("--- Veículo: " + v.getCodigo());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Ano: " + v.getAno());
            System.out.println("Chassi: " + v.getChassi());
        }
        
    }

    public void excluir() {
        System.out.println("--- Exclusão ---");
        System.out.print("Código > ");
        int codigo = Integer.parseInt(scanner.nextLine());
        
        int resultado = daoVeiculo.excluir(codigo);

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

        Veiculo v = daoVeiculo.BuscarUm(codigo);
        if (v != null){
            System.out.println("... Encontrado!");
            System.out.println("--- Veículo: " + v.getCodigo());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Ano: " + v.getAno());
            System.out.println("Chassi: " + v.getChassi());
        }
        else {
            System.out.println("Não encontrado");
        }
    }

    public void alterarVeiculo() {
        Veiculo v = new Veiculo();
        System.out.println("---------------");
        System.out.print("Selecione veículo para alterar > ");
        int codigo = Integer.parseInt(scanner.nextLine());

        v = daoVeiculo.BuscarUm(codigo);

        if(v!= null){
            System.out.println("Dados do veículo: ");
            System.out.println("Veículo: " + v.getCodigo());
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Nova marca (vazio para manter): ");
            String marca = scanner.nextLine();
            if (marca!=""){
                v.setMarca(marca);
            }

            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Novo modelo (vazio para manter): ");
            String modelo = scanner.nextLine();
            if (modelo!=""){
                v.setModelo(modelo);
            }

            System.out.println("Ano: " + v.getAno());
            System.out.println("Novo ano (vazio para manter): ");
            String ano = scanner.nextLine();
            if (ano!=""){
                int anoInt = Integer.parseInt(ano);
                v.setAno(anoInt);
            }

            System.out.println("Chassi: " + v.getChassi());
            System.out.println("Novo chassi (vazio para manter): ");
            String chassi = scanner.nextLine();
            if (chassi!=""){
                v.setChassi(chassi);
            }

        }    
        
        boolean alterado = daoVeiculo.alterar(codigo, v);
        if (alterado) {
            System.out.println("Alterado com sucesso.");
        }
    }

}
