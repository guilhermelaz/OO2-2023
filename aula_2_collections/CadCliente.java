import java.util.ArrayList;
import java.util.Iterator;

public class CadCliente {
    public static void main(String[] args) {

        //ArrayList<TIPO> nome = new ArrayList<TIPO>();
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente();

        cliente1.setNome("Guilherme");
        cliente1.setEmail("guilhermelaz@hotmail.com");
        cliente1.setCpf("12345678910");
        cliente1.setTelefone("(45) 12345-6789");
        lista.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Alice");
        cliente2.setEmail("alicelaz@hotmail.com");
        cliente2.setCpf("12345678911");
        cliente2.setTelefone("(45) 12345-6789");
        lista.add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Anderson");
        cliente3.setEmail("andersonlaz@hotmail.com");
        cliente3.setCpf("12345678912");
        cliente3.setTelefone("(45) 12345-6789");
        lista.add(cliente3);

        System.out.println("Passando pela lista: ");

        //Iterator<TIPO de objeto> nome = lista.iterator();
        //lista.iterator devolve um ponteiro para o início da lista
        Iterator<Cliente> iterador = lista.iterator();
        
        //Percorre a lista
        while (iterador.hasNext()){
            Cliente cliente = iterador.next(); //pega o próximo
            System.out.println();
            System.out.println("Cliente: " + cliente.getNome()
            + "\nCPF: " + cliente.getCpf()
            + "\nContato: " + cliente.getTelefone());
        }


        //Remover da lista
        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("12345678912");

        Iterator<Cliente> itRemover = lista.iterator(); //É bom sempre criar um novo iterator para evitar erros.
       
        while (itRemover.hasNext()){
            if(itRemover.next().getCpf().equals(cliRemover.getCpf())){
                System.out.println("Removendo cliente");
                itRemover.remove();
            }
        }

        //Percorrendo com foreach
        //"Para cada objeto ('cliente') do tipo Cliente na lista..."
        for (Cliente cliente : lista) {
            System.out.println("Cliente: " + cliente.getNome()
            + "\nCPF: " + cliente.getCpf()
            + "\nContato: " + cliente.getTelefone());
        }

        //Remover percorrendo com o foreach, é melhor usar o iterator
        for (Cliente cliente : lista) {
            if(cliente.getCpf().equals("12345678910")){
                lista.remove(cliente);
            }
        }

    }

}

