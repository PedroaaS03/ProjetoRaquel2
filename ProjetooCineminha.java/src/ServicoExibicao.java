import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoExibicao {
    private List<Exibicao> exibicoes;

    public ServicoExibicao() {
        exibicoes = new ArrayList<>();
        // Exemplo de inicialização das exibições
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala1", TipoDeSala._3D, 50), "Avatar", "13:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala2", TipoDeSala.BASIC, 50), "Narnia", "15:30"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.BASIC, 50), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.VIP, 30), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.BASIC, 50), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala.VIP, 30), "Viagem de Chico", "18:45"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala3", TipoDeSala._3D, 50), "Viagem de Chico", "18:45"));
    }

    public double buyTickets(Scanner sc) throws Exception {
        // Lógica para compra de ingressos
        try {
            System.out.println("Available Movies:");
            int index = 1;
            for (Exibicao exibicao : exibicoes) {
                System.out.println(index++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }

            System.out.print("Select a movie to book tickets for: ");
            int escolha = sc.nextInt() - 1;
            if (escolha < 0 || escolha >= exibicoes.size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            Exibicao exibicaoEscolhida = exibicoes.get(escolha);

            System.out.print("Number of tickets: ");
            int tickets = sc.nextInt();

            if (tickets > exibicaoEscolhida.getSalao().getCapacity()) {
                throw new Exception("Não há assentos suficientes disponíveis.");
            } else {
                exibicaoEscolhida.getSalao().setCapacity(exibicaoEscolhida.getSalao().getCapacity() - tickets);
                System.out.println("Tickets added to your basket.");
                return exibicaoEscolhida.getSalao().getPrecoTipoDeSala() * tickets;
            }
        } catch (Exception e) {
            throw new Exception("Erro durante a compra de ingressos: " + e.getMessage());
        }
    }

    public void addNewShowing(Scanner scanner) throws Exception {
        // Lógica para adicionar nova exibição
        try {
            System.out.println("Adicionando nova exibição...");
            System.out.print("Enter cinema hall name: ");
            String hallName = scanner.next();
            System.out.print("Enter room type (BASIC, _3D, VIP): ");
            TipoDeSala roomType = TipoDeSala.valueOf(scanner.next().toUpperCase());
            System.out.print("Enter capacity: ");
            int capacity = scanner.nextInt();
            System.out.print("Enter movie name: ");
            String movieName = scanner.next();
            System.out.print("Enter show time: ");
            String showTime = scanner.next();

            exibicoes.add(new Exibicao(new SalaDeCinema(hallName, roomType, capacity), movieName, showTime));
            System.out.println("New showing added successfully.");
        } catch (Exception e) {
            throw new Exception("Erro ao adicionar nova exibição: " + e.getMessage());
        }
    }

    public void modifyExistingShowing(Scanner scanner) throws Exception {
        // Lógica para modificar exibição existente
        try {
            System.out.println("Modifying existing showing...");
            int posicao = 1;
            for (Exibicao exibicao : exibicoes) {
                System.out.println(posicao++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }
            System.out.print("Select the index of the showing to modify: ");
            int index = scanner.nextInt() - 1;
            if (index < 0 || index >= exibicoes.size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            Exibicao exibicao = exibicoes.get(index);

            System.out.print("Enter new movie name (press Enter to keep unchanged): ");
            String newMovieName = scanner.next();
            if (!newMovieName.isEmpty()) {
                exibicao.setNomeFilme(newMovieName);
            }

            System.out.print("Enter new show time (press Enter to keep unchanged): ");
            String newShowTime = scanner.next();
            if (!newShowTime.isEmpty()) {
                exibicao.setHorarioFilmme(newShowTime);
            }
            System.out.println("Showing modified successfully.");
        } catch (Exception e) {
            throw new Exception("Erro ao modificar exibição existente: " + e.getMessage());
        }
    }

    public void removeExistingShowing(Scanner scanner) throws Exception {
        // Lógica para remover exibição existente
        try {
            System.out.println("Removing existing showing...");
            int posicao = 1;
            for (Exibicao exibicao : this.exibicoes) {
                System.out.println(posicao++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }
            System.out.print("Select the index of the showing to remove: ");
            int index = scanner.nextInt() - 1;
            if (index < 0 || index >= exibicoes.size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            exibicoes.remove(index);
            System.out.println("Showing removed successfully.");
        } catch (Exception e) {
            throw new Exception("Erro ao remover exibição existente: " + e.getMessage());
        }
    }
}