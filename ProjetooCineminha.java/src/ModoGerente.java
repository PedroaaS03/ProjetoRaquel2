import java.util.Scanner;

public class ModoGerente {

    static void enterManagerMode(Scanner scanner) {
        ServicoGerente servicoG = new ServicoGerente();
        boolean managerSession = true;
        while (managerSession) {
            try {
                System.out.println("Menu do Gerente:");
                System.out.println("1. Editar Exibições");
                System.out.println("2. Gerar Relatório");
                System.out.println("3. Sair");
                System.out.print("Selecione uma opção: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        servicoG.updateShowings(scanner);
                        break;
                    case 2:
                        servicoG.generateReports(scanner);
                        break;
                    case 3:
                        managerSession = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        throw new Exception("Opção inválida, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner após uma exceção
            }
        }
    }
}