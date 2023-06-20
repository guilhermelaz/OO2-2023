import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Aniversario{

    BufferedReader reader;
    private HashMap<String, ArrayList<String>> aniversarios;

    public static void main(String[] args) {
        
        Aniversario a = new Aniversario();
        a.reader = new BufferedReader(new InputStreamReader(System.in));
        a.aniversarios = new HashMap<String, ArrayList<String>>();
        a.menu();


    }


    public void menu(){
        int opc=0;
        
            while(opc!=4){
            System.out.println("--- Escolha ---");
            System.out.println("1. Adicionar aniversariante");
            System.out.println("2. Listar datas de aniversário");
            System.out.println("3. Consultar aniversariantes na data");
            System.out.println("4. Sair");
            System.out.println();
            try {
                System.out.print("> ");
                opc = Integer.parseInt(this.reader.readLine());
                
                switch (opc){
                    case 1:
                        cadastrardata();
                        break;
                    case 2:
                        listarDatas();
                        break;
                    case 3:
                        consultarData();
                        break;
                    
                    default:
                        System.out.println("Insira uma das opções da lista!");
                }
        } catch (IOException ioe) {
            System.out.println("Erro: Nada informado");
        } catch (NumberFormatException nfe){
            System.out.println("Erro: Informe o número de uma das opções");
        }
        }


    }

    public void cadastrardata() throws IOException{
        String data, nome;

        System.out.println();
        System.out.print("Data de aniversário: ");
        data = this.reader.readLine();
        System.out.println();

        System.out.print("Nome do cidadão: ");
        nome = this.reader.readLine();
        System.out.println();

        // Se não tem essa data adiciona uma nova "linha"
        if (!this.aniversarios.containsKey(data)){
            this.aniversarios.put(data, new ArrayList<String>());
            // pega o arraylist e adiciona o nome
            this.aniversarios.get(data).add(nome);
        }   else{
            this.aniversarios.get(data).add(nome);
        }
        
        


        ///
        System.out.println("Data cadastrada!");
    }

    public void listarDatas(){
        for (String data : aniversarios.keySet()) {
            System.out.println(data);
        }
    }

    public void consultarData() throws IOException{
        String data;

        System.out.println();
        System.out.print("Data de aniversário: ");
        data = this.reader.readLine();

        if (this.aniversarios.containsKey(data)){
            System.out.println("Aniversariantes nessa data");
            ArrayList<String> nomes = this.aniversarios.get(data);

            for (String nome : nomes) {
                System.out.println(nome);
            }
        }
        else{
            System.out.println("Nenhum nessa data");
        }

    }

}