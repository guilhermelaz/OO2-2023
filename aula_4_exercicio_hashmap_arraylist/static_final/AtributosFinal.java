public class AtributosFinal {
    private final int id = 123;


    public static void main(String[] args) {
        final float pi = 3.14f;
        // impossível: pi = 2;
        System.out.println("pi vale " + pi);

        AtributosFinal ex = new AtributosFinal();
        System.out.println("id: " + ex.id);
    }
}
