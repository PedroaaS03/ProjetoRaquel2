
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicoCliente {

    private List<Cliente> clientes;
    private List<Compra> compras;  // Armazenar as compras realizadas

    public ServicoCliente() {
        clientes = new ArrayList<>();
        compras = new ArrayList<>();  // Inicializa a lista de compras
    }
    public Cliente cadastroCliente(String nome, String email, String senha, int pontos, double totalArrecadado) throws Exception {
        for (Cliente cliente : this.clientes) {
            if (cliente.getEmail().equals(email)) {
                throw new Exception("Email já foi cadastrado");
            }
        }
        Cliente novoCliente = new Cliente(nome, email, senha, pontos, totalArrecadado);
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
                // Calculando desconto se aplicável
                if (valor > cliente.getTipoCartao().getGastoParaDesconto()) {
                    valor *= (1 - cliente.getTipoCartao().getValorDesconto());
                }
                // Adicionando pontos se aplicável
                if (valor > cliente.getTipoCartao().getGastoParaPonto()) {
                    cliente.setPontos(cliente.getPontos() + 1);
                }
                cliente.setTotalArrecadado(cliente.getTotalArrecadado() + valor);
                Compra novaCompra = new Compra(new Date(), cliente.getTipoCartao(), valor);
                compras.add(novaCompra);
                return valor;
            }
        }
        throw new Exception("Cliente não encontrado");
    }


    public void gerarRelatorio() {
        double totalArrecadado = 0;
        for (Compra compra : compras) {
            System.out.println("Data: " + compra.getDataCompra() +
                    ", Tipo do Cartão: " + compra.getTipoCartao() +
                    ", Valor: " + compra.getValorCompra());
            totalArrecadado += compra.getValorCompra();
        }
        System.out.println("Total arrecadado: " + totalArrecadado);
    }





}



