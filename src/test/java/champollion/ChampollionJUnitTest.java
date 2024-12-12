package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
	Salle B105;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
		B105 = new Salle("B105", 30);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	
	@Test
	public void testAjouteInterventions() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
		
		untel.ajouteIntervention(new Date(), 5, 10, uml, TypeIntervention.CM, B105);
		
		
	}
	
	@Test
	public void testSousEffectif() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
		untel.ajouteEnseignement(java, 0, 20, 0);
		assertTrue(untel.estEnSousService());
	}
	
}
