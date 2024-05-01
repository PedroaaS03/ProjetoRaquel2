import java.util.ArrayList;
import java.util.List;

public class ServicoGerente {
    private  List<Gerente> gerentes;


    public ServicoGerente() {
        gerentes = new ArrayList<>();
        gerentes.add(new Gerente("Pedro","1234"));
        gerentes.add(new Gerente("Miguel","1234"));
        gerentes.add(new Gerente("Junior","1234"));
        gerentes.add(new Gerente("Pedro","1234"));
    }
    public  Gerente LoginGerente(String nome, String senha){
        for (Gerente gerente : this.gerentes){
            if(gerente.getNomeGerente().equals(nome) && gerente.getSenhaGerente().equals(senha)){

                return gerente ;

            }
        }
        return null;
    }


}
