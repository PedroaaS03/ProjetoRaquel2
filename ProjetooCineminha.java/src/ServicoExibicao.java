import java.util.List;
import java.util.Scanner;

public class ServicoExibicao {

    public List<Exibicao> getExibicoes() {
        return RepositorioExibicoes.getExibicoes();
    }

    public double buyTickets(Scanner sc) throws Exception {
        // Lógica para compra de ingressos
        try {
            System.out.println("Filmes em cartaz:");
            int index = 1;
            for (Exibicao exibicao : RepositorioExibicoes.getExibicoes()) {
                System.out.println(index++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }

            System.out.print("Selecione um fime: ");
            int escolha = sc.nextInt() - 1;
            if (escolha < 0 || escolha >= getExibicoes().size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            Exibicao exibicaoEscolhida = getExibicoes().get(escolha);

            System.out.print("Numero de ingressos: ");
            int tickets = sc.nextInt();

            if (tickets > exibicaoEscolhida.getSalao().getCapacity()) {
                throw new Exception("Não há assentos suficientes disponíveis.");
            } else {
                exibicaoEscolhida.getSalao().setCapacity(exibicaoEscolhida.getSalao().getCapacity() - tickets);
                System.out.println("Ingresso adicionado na sua sacola.");
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
            System.out.print("Nome da sala de cinema: ");
            String hallName = scanner.next();
            System.out.print("Tipo de sala (BASIC, _3D, VIP): ");
            TipoDeSala roomType = TipoDeSala.valueOf(scanner.next().toUpperCase());
            System.out.print("Insira capacidade: ");
            int capacity = scanner.nextInt();
            System.out.print("Insirra o nome do filme: ");
            String movieName = scanner.next();
            System.out.print("Insira a hora do filme: ");
            String showTime = scanner.next();

            RepositorioExibicoes.addExibicao(new Exibicao(new SalaDeCinema(hallName, roomType, capacity), movieName, showTime));
            System.out.println("Nova exibição adicionada.");
        } catch (Exception e) {
            throw new Exception("Erro ao adicionar nova exibição: " + e.getMessage());
        }
    }

    public void modifyExistingShowing(Scanner scanner) throws Exception {
        // Lógica para modificar exibição existente
        try {

            int posicao = 1;
            for (Exibicao exibicao : getExibicoes()) {
                System.out.println(posicao++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }
            System.out.print("Selecione qual quer modificar: ");
            int index = scanner.nextInt() - 1;
            if (index < 0 || index >= getExibicoes().size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            Exibicao exibicao = getExibicoes().get(index);

            System.out.print("Insira o novo nome: ");
            String newMovieName = scanner.next();
            if (!newMovieName.isEmpty()) {
                exibicao.setNomeFilme(newMovieName);
            }

            System.out.print("Insira o novo horario: ");
            String newShowTime = scanner.next();
            if (!newShowTime.isEmpty()) {
                exibicao.setHorarioFilmme(newShowTime);
            }
            System.out.println("Exibição editada com sucesso.");
        } catch (Exception e) {
            throw new Exception("Erro ao modificar exibição existente: " + e.getMessage());
        }
    }

    public void removeExistingShowing(Scanner scanner) throws Exception {
        // Lógica para remover exibição existente
        try {
            System.out.println("Removing existing showing...");
            int posicao = 1;
            for (Exibicao exibicao : getExibicoes()) {
                System.out.println(posicao++ + ". " + exibicao.getNomeFilme() + " - " + exibicao.getSalao().getName() + " - " + exibicao.getSalao().getType() + " - " + exibicao.getHorarioFilmme());
            }
            System.out.print("Selecione a exibção que quer remover ");
            int index = scanner.nextInt() - 1;
            if (index < 0 || index >= getExibicoes().size()) {
                throw new Exception("Escolha inválida, tente novamente.");
            }
            RepositorioExibicoes.removeExibicao(index);
            System.out.println("Exibição removida");
        } catch (Exception e) {
            throw new Exception("Erro ao remover exibição existente: " + e.getMessage());
        }
    }
}