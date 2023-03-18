public class OperacoesMatematicas{

	public int somar(int num1, int num2){
		return num1 + num2;
	}
	
	public int subtrair(int num1, int num2){
		return num1 - num2;
	}
	
	public int multiplicar(int num1, int num2){
		return num1 * num2;
	}
	
	public float dividir(float num1, float num2) throws DivisaoPorZero{
        if(num2==0){
            throw new DivisaoPorZero();
        }
		return num1 / num2;

    }	
}

