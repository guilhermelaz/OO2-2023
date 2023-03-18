import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LancaExcecoes {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        LancaExcecoes le = new LancaExcecoes();
        le.LerArquivo();
    }

    public void LerArquivo() throws FileNotFoundException, IOException{

        String arquivoDeEntrada = "arquivo.txt";
        BufferedReader leituraArquivo = new BufferedReader(new FileReader(arquivoDeEntrada));

        String linha;
        while((linha = leituraArquivo.readLine()) != null){
            System.out.println(linha);
        }

        leituraArquivo.close();
    }
}