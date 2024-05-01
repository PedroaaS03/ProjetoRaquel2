public class Exibicao {
    private SalaDeCinema salao;
    private String nomeFilme;
    private String horarioFilmme;

    public Exibicao(SalaDeCinema salao, String nomeFilme, String horarioFilme) {
        this.salao = salao;
        this.nomeFilme = nomeFilme;
        this.horarioFilmme = horarioFilme;
    }

    public SalaDeCinema getSalao() {
        return salao;
    }

    public Double getPrecoSalao(){
        return salao.getPrecoTipoDeSala();
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getHorarioFilmme() {
        return horarioFilmme;
    }

    public void setHorarioFilmme(String horarioFilmme) {
        this.horarioFilmme = horarioFilmme;
    }
}