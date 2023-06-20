import java.util.HashMap;

public class CadEstados {
    public static void main(String[] args) {

        HashMap<String, Estado> estados = new HashMap<String, Estado>();

        Estado pr = new Estado();
        pr.setNome("Paraná");
        pr.setRegiao("Sul");
        estados.put("PR", pr);

        Estado sp = new Estado();
        sp.setNome("São Paulo");
        sp.setRegiao("Sudeste");
        estados.put("SP", sp);

        Estado mg = new Estado();
        mg.setNome("Minas Gerais");
        mg.setRegiao("Sudeste");
        estados.put("MG", mg);
        

        System.out.println("Estados armazenados: " + estados);


        System.out.println("Verificando se um estado existe:");
        String pesquisa = "SP";
        if(estados.containsKey(pesquisa)){
            System.out.println(pesquisa + " existe no sistema");
            System.out.println("Região: " + estados.get(pesquisa).getRegiao());
        }

        System.out.println("Percorrer as chaves");
        for (String chave : estados.keySet()) {
            System.out.println("Chave: " + chave);
        }

        ///
        System.out.println("Percorrer os valores");
        for (Estado e : estados.values()) {
            System.out.println("item: " + e.getNome());
        }
    }
}
