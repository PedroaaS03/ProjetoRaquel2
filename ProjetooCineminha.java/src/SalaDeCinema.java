public class SalaDeCinema {
    private String name;
    private TipoDeSala type;
    private int capacity;

    public SalaDeCinema(String name, TipoDeSala type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public Double getPrecoTipoDeSala(){
        return type.getPrice();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoDeSala getType() {
        return type;
    }

    public void setType(TipoDeSala type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}