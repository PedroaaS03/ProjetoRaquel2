public class Cliente {
    private String nomeCliente;
    private String email;
    private String senhaCliente;
    private int pontos;
    private CartaoFidelidade tipoCartao;

    public Cliente(String nome, String email, String senha, int pontos) {
        this.nomeCliente = nome;
        this.email = email;
        this.senhaCliente = senha;
        this.pontos = 0;
        this.tipoCartao = CartaoFidelidade.SILVER;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public CartaoFidelidade getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(CartaoFidelidade tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}