import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExemploExcecao {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        ExemploExcecao ee = new ExemploExcecao();

        ee.calcular();
    }

    public void calcular(){
        try {
            OperacoesMatematicas calculadora = new OperacoesMatematicas();

            float res = calculadora.dividir(3, 2);
            System.out.println(res);

            res = calculadora.dividir(10, 0);
            System.out.println(res);

        } catch (DivisaoPorZero e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}