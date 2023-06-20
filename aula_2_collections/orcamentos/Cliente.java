import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Cliente {
    private static int nextCliID = 1; // 1/2: Isso eu vi na net pra incrementar o ID
    private int cli_id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private static ArrayList<Orcamento> listaDeOrcamentos = new ArrayList<Orcamento>();


    public Cliente(String nome, String cpf, String email, String telefone){
        this.cli_id = Cliente.nextCliID++; // 2/2: Isso eu vi na net pra incrementar o ID
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        
    }

    public Cliente() {
    }

    public Cliente cadastrarCliente() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Nome do cliente: ");
        String nome = reader.readLine();
        System.out.print("CPF: ");
        String cpf = reader.readLine();
        System.out.print("E-mail: ");
        String email = reader.readLine();
        System.out.print("Telefone: ");
        String telefone = reader.readLine();

        Cliente cliente = new Cliente(nome, cpf, email, telefone);

        return cliente;
    }

    public static void novoOrcamento(int cli_id) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Equipamento: ");
        String equipamento = reader.readLine();
        System.out.print("Descricao do servico: ");
        String descricao = reader.readLine();
        System.out.print("Valor: ");
        double preco = Double.parseDouble(reader.readLine());

        Orcamento orcamento = new Orcamento(cli_id, equipamento, descricao, preco);
        listaDeOrcamentos.add(orcamento);
        
    }

    public ArrayList<Orcamento> getOrcamentosDoCliente(int idDoCliente) {
        ArrayList<Orcamento> orcamentosDoCliente = new ArrayList<Orcamento>();
        for (Orcamento orcamento : listaDeOrcamentos) {
            if (orcamento.getCli_id() == idDoCliente) {
                orcamentosDoCliente.add(orcamento);
            }
        }
        return orcamentosDoCliente;
    }

    public void ListarOrcamentos(int cli_id){

        ArrayList<Orcamento> listaCliente = getOrcamentosDoCliente(cli_id);

        for (Orcamento orcamento : listaCliente) {
            System.out.println("---");
            System.out.println("Equipamento: " + orcamento.getEquipamento());
            System.out.println("Descricao: " + orcamento.getDescricao());
            System.out.println("Valor: " + orcamento.getPreco());
            System.out.println();

        }
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getCli_id() {
        return cli_id;
    }
    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public ArrayList<Orcamento> getLista() {
        return listaDeOrcamentos;
    }



}