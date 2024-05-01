import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoLanche {


    private List<Lanche> lanches;

    public ServicoLanche() {
        lanches = new ArrayList<>();

        lanches.add(new Lanche("PipocaP", 10));
        lanches.add(new Lanche("PipocaM", 15));
        lanches.add(new Lanche("PipocaG", 20));
        lanches.add(new Lanche("Cachorro-Quente", 6));
        lanches.add(new Lanche("RefrigerentaP", 6));
        lanches.add(new Lanche("RefrigerentaM", 10));
        lanches.add(new Lanche("RefrigerentaG", 12));
    }

    public double CompraLanche(Scanner sc) {
        // Example data structure for movie exibicoes
        double valorLanches = 0;
        System.out.println("Available Movies:");
        int index = 1;
        for (Lanche lanche : this.lanches) {
            System.out.println(index++ + ". " + lanche.getNomeLanche() + " - " + lanche.getPrecoLanche());
        }

        System.out.print("Select a lanche to book lanchonete for: ");
        int escolha = sc.nextInt() - 1;
        Lanche lancheEscolhido = lanches.get(escolha);

        System.out.print("quantidade de lanches: ");
        int quantidade = sc.nextInt();

        System.out.println("Lanche added to your basket.");
        valorLanches = lancheEscolhido.getPrecoLanche() * quantidade;
        return valorLanches;
        // Assume adding to a customer's basket (not shown)


    }
}
