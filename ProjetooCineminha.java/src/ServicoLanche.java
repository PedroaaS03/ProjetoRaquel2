

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoLanche {

    private List<Lanche> lanches;

    public ServicoLanche() {
        lanches = new ArrayList<>();
        // Adicionando exemplos de lanches
        lanches.add(new Lanche("PipocaP", 10));
        lanches.add(new Lanche("PipocaM", 15));
        lanches.add(new Lanche("PipocaG", 20));
        lanches.add(new Lanche("Cachorro-Quente", 6));
        lanches.add(new Lanche("RefrigerentaP", 6));
        lanches.add(new Lanche("RefrigerentaM", 10));
        lanches.add(new Lanche("RefrigerentaG", 12));
    }

    public double CompraLanche(Scanner sc) throws Exception {
        try {
            // Lógica para compra de lanches
            System.out.println("Available Snacks:");
            int index = 1;
            for (Lanche lanche : this.lanches) {
                System.out.println(index++ + ". " + lanche.getNomeLanche() + " - " + lanche.getPrecoLanche());
            }

            System.out.print("Select a snack to buy: ");
            int escolha = sc.nextInt() - 1;
            if (escolha < 0 || escolha >= lanches.size()) {
                throw new Exception("Opção inválida, tente novamente.");
            }
            Lanche lancheEscolhido = lanches.get(escolha);

            System.out.print("Quantity of snacks: ");
            int quantidade = sc.nextInt();

            System.out.println("Snack added to your basket.");
            return lancheEscolhido.getPrecoLanche() * quantidade;
        } catch (Exception e) {
            throw new Exception("Erro durante a compra de lanche: " + e.getMessage());
        }
    }
}