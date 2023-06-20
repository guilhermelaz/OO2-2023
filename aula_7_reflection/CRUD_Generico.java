public class CRUD_Generico {
    public static void main(String[] args) throws Exception{
        DaoGenerico dao = new DaoGenerico();
        
        // Veiculo v = new Veiculo();

        // v.setAno(2019);
        // v.setMarca("Toyota");
        // v.setModelo("Corolla");
        // v.setChassi("1234567890");

        // dao.inserir(v);
    
        
        Pet superPet = new Pet();

        superPet.setCor("Branco");
        superPet.setIdade(100);
        superPet.setNome("Maximus");
        superPet.setPeso(216.35);
        superPet.setTipo("BigChungus");

        dao.inserir(superPet);

    }
}
