import java.util.Scanner;

public class ModoCliente {

    static void enterCustomerMode(String email) {
        Scanner sc = new Scanner(System.in);
        double totalGeral = 0;
        double totalDaCompra = 0;
        double totalIngresso = 0;
        double totalLanche = 0;
        boolean customerSession = true;
        while (customerSession) {
            try {
                System.out.println(" - Cliente Menu - ");
                System.out.println("1. Comprar Ingresso");
                System.out.println("2. Comprar Lanche");
                System.out.println("3. Finalizar Compra");
                System.out.println("4. Cancelar e Sair");
                System.out.print("Selecione uma opção: ");
                int choice = sc.nextInt();
                totalDaCompra = totalIngresso + totalLanche;
                totalGeral = totalDaCompra + totalGeral;
                switch (choice) {
                    case 1:
                        ServicoExibicao servicoEx = new ServicoExibicao();
                        // Function to handle ticket buying
                        totalIngresso = totalIngresso + servicoEx.buyTickets(sc);
                        break;
                    case 2:
                        ServicoLanche servicoLa = new ServicoLanche();
                        totalLanche = totalLanche + servicoLa.CompraLanche(sc);
                        break;
                    case 3:
                        ServicoCliente servicoC = new ServicoCliente();
                        System.out.println(" - Fechando Pedido - ");
                        System.out.println("Valor total da compra: " + totalGeral);
                        System.out.println("Total a pagar: " + servicoC.fecharPedido(email, totalGeral));
                        System.out.println("Realizar o pagamento: ");
                        System.out.println("Sim(1) ou Não(2)");
                        int realizar = sc.nextInt();
                        if (realizar == 1) {
                            System.out.println("Obrigado pela compra, volte sempre");
                            customerSession = false;
                        }
                        break;
                    case 4:
                        customerSession = false;
                        System.out.println("Saindo do modo Cliente...");
                        break;
                    default:
                        throw new Exception("Opção inválida, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // Limpar o buffer do scanner após uma exceção
            }
        }
        sc.close();
    }
}