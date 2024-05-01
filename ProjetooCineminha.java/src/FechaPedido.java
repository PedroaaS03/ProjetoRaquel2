public class FechaPedido {

    public double fecharPedido(String nome, String senha, double valor) {
        ServicoCliente servicoC = new ServicoCliente();

        if (valor > (servicoC.LoginCliente(nome, senha)).getTipoCartao().getGastoParaPonto()) {
            (servicoC.LoginCliente(nome, senha)).setPontos((servicoC.LoginCliente(nome, senha)).getPontos() + 1);
        }
        if (valor > (servicoC.LoginCliente(nome, senha)).getTipoCartao().getGastoParaDesconto()) {
            double valorTotal = valor * (servicoC.LoginCliente(nome, senha)).getTipoCartao().getValorDesconto();
            return valorTotal;


        }
        return valor;
    }
}


