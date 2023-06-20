import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Locadora loc = new Locadora();
        loc.menu();
    }

    public void menu(){
        int opc = 0;
        Scanner scanner = new Scanner(System.in);
        
        while(opc != 3){
            try {
                System.out.println("--- Escolha opção ---");
                System.out.println("[1] Veículos");
                System.out.println("[2] Clientes");
                System.out.println("[3] Gerenciar clientes PJ");
                System.out.println("[4] Sair");
                opc = Integer.parseInt(scanner.nextLine());
                switch (opc) {
                    case 1:
                        GerenciadorVeiculo gv = new GerenciadorVeiculo();
                        gv.menu();
                        opc = 0;
                        break;
                    case 2:
                        GerenciadorCliente gc = new GerenciadorCliente();
                        gc.menu();
                        opc = 0;
                        break;
                    case 3:
                        GerenciadorClientePJ gcpj = new GerenciadorClientePJ();
                        gcpj.menu();
                        break;
                    default:
                        System.out.println("Escolha uma opção da lista.");
                }
                scanner.close();
            } catch (NumberFormatException e) {
                System.out.println("Insira um número válido.");
            } catch (Exception e) {
                System.out.println("Erro genérico. Tente novamente.");
            }
            
        }

    }

}
