import java.util.Date;

public class Compra {
    private Date dataCompra;
    private CartaoFidelidade tipoCartao;
    private double valorCompra;

    public Compra(Date dataCompra, CartaoFidelidade tipoCartao, double valorCompra) {
        this.dataCompra = dataCompra;
        this.tipoCartao = tipoCartao;
        this.valorCompra = valorCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public CartaoFidelidade getTipoCartao() {
        return tipoCartao;
    }

    public double getValorCompra() {
        return valorCompra;
    }
}