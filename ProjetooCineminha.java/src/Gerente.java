public class Gerente {

    private String nomeGerente;
    private String senhaGerente;

    public Gerente(String nomeGerente, String senhaGerente){
        this.nomeGerente = nomeGerente;
        this.senhaGerente = senhaGerente;

    }

    public String getNomeGerente(){
        return nomeGerente;
    }

    public String getSenhaGerente(){
        return senhaGerente;
    }

}