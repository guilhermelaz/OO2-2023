import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcesoes {
    public static void main(String[] args) {
        TrataExcesoes te = new TrataExcesoes();
        te.LerArquivo();
    }

    public void LerArquivo() {

        try{
            String arquivoDeEntrada = "arquiv.txt";
            BufferedReader leituraArquivo = new BufferedReader(new FileReader(arquivoDeEntrada));
    
            String linha;
            while((linha = leituraArquivo.readLine()) != null){
                System.out.println(linha);
            }
            leituraArquivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("Arquivo não encontrado.");
        }catch(IOException e2){
            System.out.println("Erro na leitura.");
        }catch(Exception e){ // Colocar os catchs em ordem do mais especializado para o mais genérico, nesse caso o "Exception" sempre fica por último
            System.out.println("Erro genérico >:(");
            System.out.println(e.getMessage());
        }finally{ // Executado sempre
            System.out.println("Encerrando.");
        }

    }

}
