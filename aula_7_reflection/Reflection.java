import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Reflection {
    
    public static void main(String[] args) {

        try {
            Class c = Class.forName("Veiculo"); // sabe o nome da classe, mas não sabe o que tem dentro dela
            // Ou Veiculo v = new Veiculo(); Class c = v.getClass();

            System.out.println("Nome da classe: " + c.getName());


            System.out.println("\n\n");
            System.out.println("--- GetDeclaredFields (Atributos) ---");

            System.out.println("Atributos: ");
            Field fields[] = c.getDeclaredFields();
            for (Field field : fields) {
                // System.out.println(field.toString());
                System.out.println(field.getName() + " - " + field.getType());
            }
            
            System.out.println("\n\n");
            System.out.println("--- GetDeclaredMethods ---");

            System.out.println("Métodos: ");
            Method methods[] = c.getDeclaredMethods();
            for (Method method : methods) {
                // System.out.println(method.toString());
                System.out.println(method.getName());
                Parameter parameters[] = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getParameterizedType() + " " + parameter.getName());
                }
                
                System.out.println("\n\n");
                System.out.println("--- INVOKE ---");

                if (method.getName().equals("setAno")) {
                    method.invoke(c.newInstance(), 2019);
                    System.out.println("Método setAno invocado!");
                }

            }




        } catch (Throwable e) {
            // Throwable é a superclasse de todos os erros e exceções do Java
            System.err.println(e);
        }

        
        
    }


}
