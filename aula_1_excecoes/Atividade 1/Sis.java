import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sis {
    Pedidos[] lista = new Pedidos[1000];
    int counter=0;
    int ok = 1;

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Calendar cal = Calendar.getInstance();
    static SimpleDateFormat fpadrao = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Sis sis = new Sis();
        int opc = 0;

        while (opc != 3){

            sis.menu();
            try {
                opc = Integer.parseInt(reader.readLine());
                switch (opc){
                    case 1:
                        sis.lerArquivo();
                        break;
                    case 2:
                        sis.listar();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Insira uma opção da lista!");
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Insira um valor válido!");
            }


        }
        
        
        
    }

    public void lerArquivo() {

        String arquivo;
        
        System.out.println("Abrir arquivo: ");

        try{

            arquivo = reader.readLine();
            String arquivoDeEntrada = arquivo;

            File file = new File(arquivoDeEntrada);
            if (file.length() == 0) {
                throw new ArquivoVazio();
            }

            BufferedReader leituraArquivo = new BufferedReader(new FileReader(arquivoDeEntrada));
            
            String linha;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            try{
                while((linha = leituraArquivo.readLine()) != null){
                    String[] col = linha.split(";");

                    String nome = col[0];
        
                    //todo: fazer a leitura da string, converter pra data, somar 7 dias e printar na tela formato dd/MM/yyyy
                    String dataLidaNoArquivo = col[1];
                    Date data = formato.parse(dataLidaNoArquivo);
                    cal.setTime(data);
                    cal.add(Calendar.DAY_OF_MONTH, 7);

                    Pedidos pedido = new Pedidos(nome, cal.getTime());
                    if (cal.getTime()!=null){
                        cadastrarPedido(pedido);
                    }
                }
            }
            catch(ParseException e){
                System.out.println();
                System.out.println("Erro ao ler o arquivo! (Data inválida!)");
            }

            leituraArquivo.close();

        }catch(FileNotFoundException e1){
            System.out.println();
            System.out.println("Arquivo não encontrado.");
            ok = 0;
        }catch(IOException e2){
            System.out.println();
            System.out.println("Erro na leitura.");
            ok = 0;
        }catch (ArquivoVazio ea) {
            System.out.println(ea.getMessage());
            ok =0;
        }catch(Exception e){ // Colocar os catchs em ordem do mais especializado para o mais genérico, nesse caso o "Exception" sempre fica por último
            System.out.println("Erro genérico >:(");
            System.out.println(e.getMessage());
            ok = 0;
        }//}finally{ // Executado sempre
        
        if (ok == 1){
            System.out.println();
            System.out.println("Arquivo lido com sucesso!");
        }
        
    }

    public void cadastrarPedido(Pedidos pedido){
        this.lista[counter] = pedido;
        counter++;
    }

    public void listar(){
        int i=0;
        while(this.lista[i] != null){
            System.out.println();
            System.out.println("Pedido " + (i+1) + ":");
            System.out.println("Nome: " + this.lista[i].nome);
            System.out.println("Entrega limite: " + fpadrao.format(this.lista[i].dataLimite));
            i++;
        }
    }

    public void menu(){
        System.out.println();
        System.out.println("#### Menu ####");
        System.out.println("1. Ler o arquivo");
        System.out.println("2. Exibir pedidos");
        System.out.println("3. Sair");
    }

}
