import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoExibicao {

    private  List<Exibicao> exibicoes;
    public ServicoExibicao() {
        exibicoes = new ArrayList<>();
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala1", TipoDeSala._3D, 50), "Avatar", "13:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala2", TipoDeSala.BASIC, 50), "Narnia", "15:30"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.BASIC, 50), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.VIP, 30), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.BASIC, 50), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.VIP, 30), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala._3D, 50), "Viagem de Chico", "18:45"));
    }
    // Assume these are normally loaded from a file

    public  double buyTickets(Scanner sc) {
        // Example data structure for movie exibicoes

        System.out.println("Available Movies:");
        int index = 1;
        for (Exibicao exibicao : this.exibicoes) {
            System.out.println(index++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() +" - " + exibicao.getHorarioFilmme());
        }

        System.out.print("Select a movie to book tickets for: ");
        int escolha = sc.nextInt() - 1;
        Exibicao exibicaoEscolhida = exibicoes.get(escolha);

        System.out.print("Number of tickets: ");
        int tickets = sc.nextInt();

        if (tickets > exibicaoEscolhida.getSalao().getCapacity()) {
            System.out.println("Not enough seats available.");
        } else {
            exibicaoEscolhida.getSalao().setCapacity(exibicaoEscolhida.getSalao().getCapacity() - tickets);
            System.out.println("Tickets added to your basket.");
            double precoIngressos = exibicaoEscolhida.getSalao().getPrecoTipoDeSala() * tickets;
            return precoIngressos;

            // Assume adding to a customer's basket (not shown)
        }
        return 0;
    }


}
