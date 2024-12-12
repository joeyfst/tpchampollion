package champollion;

public class ServicePrevu {
	
	private int volumeCM;
	private int volumeTD;
	private int volumeTP;
	
	private Enseignant enseignant;
	
	private UE UE;
	
	public ServicePrevu(Enseignant newEnseignant, UE newUE, int CM, int TD, int TP) {
		enseignant = newEnseignant;
		UE = newUE;
		volumeCM = CM;
		volumeTD = TD;
		volumeTP = TP;
	}
	
	public UE getUE(){
		return UE;
	}
	
	public int getVolumeCM() {
		return volumeCM;
	}
	
	public int getVolumeTD() {
		return volumeTD;
	}
	
	public int getVolumeTP() {
		return volumeTP;
	}
	
	public int getVolumeHeures() {
		return (int)Math.round((volumeCM * 1.5) + volumeTD + (volumeTP * 0.75));
	}

}
