package champollion;

import java.util.Date;

public class Intervention {
	
	private Date debut;
	private int duree;
	private boolean annulee = false;
	private int heureDebut;
	private UE ue;
	private Enseignant enseignant;
	private TypeIntervention typeIntervention;
	private Salle salle;
	
	public Intervention(Date debut, int duree, int heureDebut, UE ue, Enseignant enseignant, TypeIntervention typeIntervention, Salle salle) {
		this.debut = debut;
		this.duree = duree;
		this.heureDebut = heureDebut;
		this.ue = ue;
		this.enseignant = enseignant;
		this.typeIntervention = typeIntervention;
		this.salle = salle;
	}
	
	public int getDuree() {
		return duree;
	}
	
	public UE getUE() {
		return ue;
	}
	
	public TypeIntervention getTypeIntervention() {
		return typeIntervention;
	}
}
