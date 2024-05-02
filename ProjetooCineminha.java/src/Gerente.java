import java.io.Serializable;

public class Gerente implements Serializable {
    private static final long serialVersionUID = 1L;

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