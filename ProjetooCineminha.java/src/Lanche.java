import java.io.Serializable;

public class Lanche implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeLanche;
    private double precoLanche;

    public Lanche(String nomeLanche, double precoLanche){
        this.nomeLanche = nomeLanche;
        this.precoLanche = precoLanche;
    }

    public String getNomeLanche(){
        return nomeLanche;
    }

    public double getPrecoLanche(){
        return precoLanche;
    }

}