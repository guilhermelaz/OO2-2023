public class Estatico {
    public static void main(String[] args) {

        System.out.println("Criando cliente Shrek");
        Cliente c1 = new Cliente();
        c1.setCpf("12345678910");
        c1.setNome("Shrek");
        c1.setEmail("Shrek@dreamworks.com");
        c1.setTelefone("911");
        
        System.out.println("Total de clientes (c1): " + c1.qt);
        
        //////////////////////////////////////////////
        System.out.println("Criando cliente Burro");
        Cliente c2 = new Cliente();
        c2.setCpf("23456789011");
        c2.setNome("Burro");
        c2.setEmail("Burro@dreamworks.com");
        c2.setTelefone("190");

        System.out.println("Total de clientes (c1): " + c1.qt);
        System.out.println("Total de clientes (c2): " + c2.qt);
        System.out.println("Total de clientes (class): " + Cliente.qt);
    }
}
