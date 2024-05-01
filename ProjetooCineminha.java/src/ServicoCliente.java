import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoCliente {

    private List<Cliente> clientes;

    public ServicoCliente() {
        clientes = new ArrayList<>();
    }

    public Cliente cadastroCliente(String nome, String email, String senha, int pontos) throws Exception {
        for (Cliente cliente : this.clientes) {
            if (cliente.getEmail().equals(email)) {
                throw new Exception("Email já foi cadastrado");
            }
        }
        Cliente novoCliente = new Cliente(nome, email, senha, pontos);
        clientes.add(novoCliente);
        return novoCliente;
    }

    public Cliente loginCliente(String nome, String senha) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.getNomeCliente().equals(nome) && cliente.getSenhaCliente().equals(senha)) {
                return cliente;
            }
        }
        throw new Exception("Credenciais de login inválidas");
    }

    public double fecharPedido(String email, double valor) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                if (valor > cliente.getTipoCartao().getGastoParaPonto()) {
                    cliente.setPontos(cliente.getPontos() + 1);
                }
                if (valor > cliente.getTipoCartao().getGastoParaDesconto()) {
                    double valorTotal = valor * cliente.getTipoCartao().getValorDesconto();
                    return valorTotal;
                }
            }
        }
        throw new Exception("Cliente não encontrado");
    }
}