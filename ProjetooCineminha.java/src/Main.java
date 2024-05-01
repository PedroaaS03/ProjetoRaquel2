import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServicoCliente servicoC = new ServicoCliente();
        ServicoGerente servicoG = new ServicoGerente();
        Scanner sc = new Scanner(System.in);
        boolean runApp = true;

        while (runApp) {
            System.out.println("\nWelcome to the Cinema Ticket System!");
            System.out.println("1. Register");
            System.out.println("2. Customer Mode");
            System.out.println("3. Manager Mode");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" - Cadastro - ");
                    System.out.println("Insira um nome:");
                    String nomeC = sc.next();
                    System.out.println("Insira um email:");
                    String email = sc.next();
                    System.out.println("Insira uma senha:");
                    String senhaC = sc.next();
                    int pontos = 0;
                    if(servicoC.CadastroCliente(nomeC,email,senhaC,pontos) != null){
                        System.out.println("Cadastro bem sucedido");
                    }else{
                        System.out.println("Email já foi cadastrado");
                    }

                    break;
                case 2:
                    System.out.println("- Login -");
                    System.out.println("Nome de usuário: ");
                    String nomeLoginC = sc.next();
                    System.out.println("Senha: ");
                    String senhaLoginC = sc.next();
                    if(servicoC.LoginCliente(nomeLoginC,senhaLoginC) != null) {
                        System.out.println("Bem-vindo " + nomeLoginC);
                        ModoCliente.enterCustomerMode(nomeLoginC, senhaLoginC);
                    }
                    break;
                case 3:
                    System.out.println("- Login -");
                    System.out.println("Nome de usuário: ");
                    String nomeLoginG = sc.next();
                    System.out.println("Senha: ");
                    String senhaLoginG = sc.next();
                    if(servicoG.LoginGerente(nomeLoginG, senhaLoginG) != null){
                        System.out.println("Bem-vindo" + nomeLoginG);
                        ModoGerente.enterManagerMode(sc);
                    }

                    break;
                case 4:
                    runApp = false;
                    System.out.println("Exiting... Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        sc.close();
    }



}