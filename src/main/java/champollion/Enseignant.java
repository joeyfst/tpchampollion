package champollion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Un enseignant est caractérisé par les informations suivantes : son nom, son adresse email, et son service prévu,
 * et son emploi du temps.
 */
public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

	private final List<Intervention> interventions = new LinkedList<>();
	
	private final List<ServicePrevu> services = new LinkedList<>();
	
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
    	int heures = 0;
        for(ServicePrevu service : services) {
        	heures += service.getVolumeHeures();
        }
        return heures;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
    	int heures = 0;
        for(ServicePrevu service : services) {
        	if(service.getUE().getIntitule().equals(ue.getIntitule())) {
            	heures += service.getVolumeHeures();
        	}
        }
        return heures;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu ServicePrevu = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTP);
        services.add(ServicePrevu);    
    }
    
    public void ajouteIntervention(Date debut, int duree, int heureDebut, UE ue, TypeIntervention typeIntervention, Salle salle) {
    	Intervention intervention = new Intervention(debut, duree, heureDebut, ue, this, typeIntervention, salle);
    	interventions.add(intervention);
    }
    
    public void heuresIntervention() {
    	int heures = 0;
    	
    }
    
    public void resteAPlanifier(UE ue, TypeIntervention typeIntervention) {
    	int volumeService = heuresPrevuesPourUE(ue);
    	int volumeIntervention = 0;
    	for(Intervention i : interventions) {
    		if(i.getUE() == ue && i.getTypeIntervention() == typeIntervention) {
    			volumeIntervention += i.getDuree();
    		}
    	}
    	if(volumeService - volumeIntervention > 0) {
    		System.out.println("Il reste "+(volumeService - volumeIntervention)+" heures à effectuer pour l'UE "+ue+" en "+typeIntervention);
    	}
    }
    
    public boolean estEnSousService() {
    	int total = 0;
    	for(ServicePrevu s : services) {
    		total += s.getVolumeHeures();
    	}
    	if(total < 192) {
    		System.out.println("L'enseignant est en sous-service");
    		return true;
    	}else {
    		System.out.println("L'enseignant n'est pas en sous-service");
    		return false;
    	}
    	
    }

}
