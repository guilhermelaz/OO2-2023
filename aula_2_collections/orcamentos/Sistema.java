import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        
        Sistema sis = new Sistema();
        
        int opc = -1;

        while (opc != 0){
            try {
                sis.menu();
                opc = Integer.parseInt(sis.reader.readLine());
    
                switch (opc){
                    case 1:
                        Cliente c = new Cliente();

                        Cliente cli = c.cadastrarCliente();
                        sis.listaDeClientes.add(cli);

                        break;
                    case 2:
                        System.out.println("--- Lista de clientes ---");
                        for (Cliente cliente : sis.listaDeClientes) {            
                            System.out.println("Cliente " + cliente.getCli_id());
                            System.out.println("Nome: " + cliente.getNome());
                            System.out.println("CPF: " + cliente.getCpf());
                            System.out.println("Email: " + cliente.getEmail());
                            System.out.println("Contato: " + cliente.getTelefone());
                            System.out.println();
                        }          
                        break;
                    case 3:
                        System.out.println("--- Cadastro de orçamento ---");

                        System.out.print("Id do cliente: ");
                        int cli_id = Integer.parseInt(sis.reader.readLine());

                        Cliente.novoOrcamento(cli_id);
                        
                        break;

                    case 4:
                        System.out.print("Id do cliente:");
                        cli_id = Integer.parseInt(sis.reader.readLine());

                        System.out.println("--- Orçamentos ---");
                        Cliente c2 = new Cliente();
                        c2.ListarOrcamentos(cli_id);                        

                    default:
                        System.out.println("Insira uma opção da lista!");
                }
            } catch (IOException ioe) {
                System.out.println("Erro de IO.");
            } catch (NumberFormatException nfe){
                System.out.println("Insira um número.");
            }
            

        }


    }

    public void menu(){
        System.out.println();
        System.out.println("--- Menu ---");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Lista de clientes");
        System.out.println("3. Cadastrar orcamento para cliente");
        System.out.println("4. Listar orcamentos do cliente");
        System.out.println("0 - Sair");
    }
}