import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.lang.NumberFormatException;

public class AirSys {

    static HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        
        AirSys sis = new AirSys();

        int opc=0;

        while(opc != 5){

            sis.menu();

            try{
                System.out.print("Select > ");
                opc = Integer.parseInt(reader.readLine());

                switch (opc){
                    case 1:
                        System.out.print("Nome do aeroporto: ");
                        String aeroportoNome = reader.readLine();
                        System.out.println();
                        System.out.print("Sigla: ");
                        String aeroportoSigla = reader.readLine();
                        System.out.println();
                        System.out.print("Cidade localizado: ");
                        String aeroportoCidade = reader.readLine();
                        System.out.println();
                        System.out.print("Altitude: ");
                        Float aeroportoAltitude = Float.parseFloat(reader.readLine());
                        System.out.println();

                        sis.cadastrarAeroporto(aeroportoNome, aeroportoCidade, aeroportoAltitude, aeroportoSigla);

                        break;
                    
                    case 2:
                        System.out.println("* Lista de aeroportos *");
                        
                        for (String aer : aeroportos.keySet()) {
                            System.out.println(aer);
                        }
                        break;
                    
                    case 3:
                        System.out.print("Remover aeroporto > ");
                        String rem = reader.readLine();
                        sis.removerAeroporto(rem);
                        break;

                    case 4:
                        System.out.print("Consultar detalhes do aeroporto >");
                        String cons = reader.readLine();
                        sis.consultarAeroporto(cons);

                        break;

                    default:
                        System.out.println("Escolha uma opção da lista!");
                }
            }catch(IOException ioe){
                System.out.println("***Não foi possível ler, IOException");
            }catch(NumberFormatException nume){
                System.out.println("***Não foi possível converter a altitude, favor inserir um valor numérico!");
            }


        }
        
        
    }

    public void menu(){
        System.out.println("--- menu ---");
        System.out.println("1. Cadastrar aeroporto");
        System.out.println("2. Visualizar aeroportos cadastrados");
        System.out.println("3. Remover aeroporto");
        System.out.println("4. Detalhes do aeroporto");
        System.out.println("5. Fechar");
        System.out.println();
    }

    public void cadastrarAeroporto(String nome, String cid, Float alt, String sig) throws IOException{
        Aeroporto ae = new Aeroporto();
        ae.setNome(nome);
        ae.setCidade(cid);
        ae.setAltitude(alt);

        aeroportos.put(sig, ae);
    }

    public void removerAeroporto(String chave){
        if(aeroportos.containsKey(chave)){
            aeroportos.remove(chave);
        }
        else{
            System.out.println("Aeroporto não encontrado");
        }
    }

    public void consultarAeroporto(String cons){
        if(aeroportos.containsKey(cons)){
            Aeroporto aeroporto = aeroportos.get(cons);
            System.out.println("* Detalhes do aeroporto " + aeroporto.getNome() + " *");
            System.out.println("Nome: " + aeroporto.getNome());
            System.out.println("Cidade: " + aeroporto.getCidade());
            System.out.println("Altitude: " + aeroporto.getAltitude());
        }
        else{
            System.out.println("Aeroporto não encontrado");
        }
    }
}