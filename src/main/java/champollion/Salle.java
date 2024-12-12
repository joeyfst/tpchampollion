package champollion;

public class Salle {
    private final String myIntitule;
    private int capacite;
    
    public Salle(String intitule, int capacite) {
        myIntitule = intitule;
        this.capacite = capacite;
    }

    public String getIntitule() {
        return myIntitule;
    }
    
    public int getCapacite() {
    	return capacite;
    }
}
