import java.util.HashMap;

public class Dias {
    public static void main(String[] args) {
     
        HashMap<String, String> diasSemana = new HashMap<String, String>();

        diasSemana.put("SEG", "Segunda-feira");
        diasSemana.put("TER", "Terça-feira");
        diasSemana.put("QUA", "Quarta-feira");
        diasSemana.put("QUI", "Quinta-feira");
        diasSemana.put("SEX", "Sexta-feira");
        diasSemana.put("SAB", "Sábado");
        diasSemana.put("DOM", "Domingo");

        ///
        System.out.println("Mostrando os pares armazenados");
        System.out.println(diasSemana);

        ///
        System.out.println("Verificando se um dia existe:");
        System.out.println("QUA existe? " + diasSemana.containsKey("QUA"));
        System.out.println("XYS existe? " + diasSemana.containsKey("XYS"));

        ///
        System.out.println("Pegar item a partir da chave:");
        System.out.println(diasSemana.get("DOM"));

        ///
        System.out.println("Quantidade de itens: " + diasSemana.size());

        ///
        System.out.println("Remover um item:");
        diasSemana.remove("SEG");
        System.out.println("Novo tamanho: " + diasSemana.size());

        ///
        System.out.println("Percorrer as chaves");
        for (String chave : diasSemana.keySet()) {
            System.out.println("Chave: " + chave);
        }

        ///
        System.out.println("Percorrer os valores");
        for (String item : diasSemana.values()) {
            System.out.println("item: " + item);
        }

        ///
        System.out.println("removendo todos os pares");
        diasSemana.clear();
        System.out.println("Quantidade de itens: " + diasSemana.size());
    }
}