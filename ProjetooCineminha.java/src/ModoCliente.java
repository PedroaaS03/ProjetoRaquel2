import java.util.Scanner;

public class ModoCliente {


    static void enterCustomerMode(String nomeC, String senhaC) {
        Scanner sc = new Scanner(System.in);
        double totalGeral = 0;
        double totalDaCompra = 0;
        double totalIngresso = 0;
        double totalLanche = 0;
        boolean customerSession = true;
        while (customerSession) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Buy Tickets");
            System.out.println("2. Buy Snacks");
            System.out.println("3. Checkout");
            System.out.println("4. Cancel and Exit");
            System.out.print("Select an option: ");
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
                    FechaPedido fechaP = new FechaPedido();
                    System.out.println(" - Fechando Pedido - ");
                    System.out.println("Valor total da compra: " + totalGeral);
                    System.out.println("Total a pagar: " + fechaP.fecharPedido(nomeC,senhaC, totalGeral));
                    System.out.println("Realizar o pagamento: ");
                    System.out.println("Sim(1) ou Não(2)");
                    int realizar = sc.nextInt();
                    if(realizar == 1){
                        System.out.println("Obrigado pela compra, volte sempre");
                        customerSession = false;

                    }

                    break;
                case 4:
                    customerSession = false;
                    System.out.println("Exiting customer mode...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }


}
