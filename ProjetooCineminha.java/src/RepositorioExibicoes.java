

import java.util.ArrayList;
import java.util.List;

public class RepositorioExibicoes {

    private static List<Exibicao> exibicoes;

    static {
        exibicoes = new ArrayList<>();
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.BASIC, 100), "Viagem de Chico", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala._3D, 100), "Harry o Potter", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.BASIC, 100), " Avatar", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala._3D, 100), " Vingadores", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.BASIC, 100), " Tá dando onda", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.VIP, 50), "Stuar little ", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.BASIC, 100), "Minha mãe é uma peça", "10:00"));
        exibicoes.add(new Exibicao(new SalaDeCinema("Sala 1", TipoDeSala.VIP, 50), " A arca de Noé", "10:00"));
    }

    public static void addExibicao(Exibicao exibicao) {
        exibicoes.add(exibicao);
    }

    public static void removeExibicao(Exibicao exibicao) {
        exibicoes.remove(exibicao);
    }

    public static void removeExibicao(int index) {
        exibicoes.remove(index);
    }


    public static List<Exibicao> getExibicoes() {
        return exibicoes;
    }
}