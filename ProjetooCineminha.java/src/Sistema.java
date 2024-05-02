import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Cliente> clientes;
    private List<Gerente> gerentes;
    private List<Exibicao> exibicoes;
    private List<Lanche> lanches;

    public Sistema() {
        carregarDados();
    }

    public void carregarDados() {
        try {
            this.clientes = (List<Cliente>) Persistencia.carregarDados("clientes.ser");
            this.gerentes = (List<Gerente>) Persistencia.carregarDados("gerentes.ser");
            this.exibicoes = (List<Exibicao>) Persistencia.carregarDados("exibicoes.ser");
            this.lanches = (List<Lanche>) Persistencia.carregarDados("lanches.ser");
        } catch (IOException | ClassNotFoundException e) {
            // Inicializa listas vazias caso não consiga carregar os dados
            this.clientes = new ArrayList<>();
            this.gerentes = new ArrayList<>();
            this.exibicoes = new ArrayList<>();
            this.lanches = new ArrayList<>();
            System.out.println("Dados iniciais carregados. Novos dados serão criados.");
        }
    }

    public void salvarDados() {
        try {
            Persistencia.salvarDados("clientes.ser", clientes);
            Persistencia.salvarDados("gerentes.ser", gerentes);
            Persistencia.salvarDados("exibicoes.ser", exibicoes);
            Persistencia.salvarDados("lanches.ser", lanches);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void encerrarSistema() {
        salvarDados();
        System.out.println("Sistema encerrado.");
    }
}