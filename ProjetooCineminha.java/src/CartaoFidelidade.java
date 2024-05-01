public enum CartaoFidelidade {
    SILVER(35, 0, 0),
    GOLD(40, 120, 0.03),
    PLATINUM(45, 160, 0.06),
    BLACK(50, 200, 0.12);

    private final double gastoParaPonto;
    private final double gastoParaDesconto;
    private final double valorDesconto;

    CartaoFidelidade(double gastoParaPonto, double gastoParaDesconto, double valorDesconto) {
        this.gastoParaPonto = gastoParaPonto;
        this.gastoParaDesconto = gastoParaDesconto;
        this.valorDesconto = valorDesconto;
    }

    public double getGastoParaPonto() {
        return this.gastoParaPonto;
    }

    public double getGastoParaDesconto() {
        return this.gastoParaDesconto;
    }

    public double getValorDesconto() {
        return this.valorDesconto;
    }



}
