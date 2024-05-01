import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoGerente {
    private List<Gerente> gerentes;

    public ServicoGerente() {
        gerentes = new ArrayList<>();
        gerentes.add(new Gerente("Pedro", "1234"));
        gerentes.add(new Gerente("Miguel", "1234"));
        gerentes.add(new Gerente("Junior", "1234"));
        gerentes.add(new Gerente("Raquel", "1234"));
    }

    public Gerente LoginGerente(String nome, String senha) throws Exception {
        for (Gerente gerente : this.gerentes) {
            if (gerente.getNomeGerente().equals(nome) && gerente.getSenhaGerente().equals(senha)) {
                return gerente;
            }
        }
        throw new Exception("Credenciais de login do gerente inválidas");
    }

    public void updateShowings(Scanner scanner) throws Exception {
        ServicoExibicao servicoEx = new ServicoExibicao();

        System.out.println("Updating showings...");
        System.out.println("1. Add new showing");
        System.out.println("2. Modify existing showing");
        System.out.println("3. Remove existing showing");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                servicoEx.addNewShowing(scanner);
                break;
            case 2:
                servicoEx.modifyExistingShowing(scanner);
                break;
            case 3:
                servicoEx.removeExistingShowing(scanner);
                break;
            default:
                throw new Exception("Opção inválida, tente novamente.");
        }
    }

    public void generateReports(Scanner scanner) {
        System.out.println("Generating reports...");
        // Lógica para gerar relatórios de vendas
    }
}