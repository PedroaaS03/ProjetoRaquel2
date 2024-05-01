public class Lanche {

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
