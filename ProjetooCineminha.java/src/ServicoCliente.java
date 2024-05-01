import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {

    private List<Cliente> clientes;
    public ServicoCliente() {
        clientes = new ArrayList<>();

    }

    public Cliente CadastroCliente(String nome, String email, String senha, int pontos){
        for (Cliente cliente: this.clientes){
            if(cliente.getEmail().equals(email)) {
                return null;
            }
        }
        Cliente novoCliente = new Cliente(nome, email, senha, pontos);
        clientes.add(novoCliente);
        return novoCliente;
    }

    public Cliente LoginCliente(String nome, String senha){
        for (Cliente cliente : this.clientes){
            if(cliente.getNomeCliente().equals(nome) && cliente.getSenhaCliente().equals(senha)){
                return cliente;
            }
        }
        return null;
    }


}
