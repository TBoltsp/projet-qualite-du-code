import java.sql.Date;
import java.util.ArrayList;

public class Calendrier {

	ArrayList<PlageHoraire> liste;
	
	public Calendrier() {
		liste = new ArrayList<>();
	}
	
	public void ajoutCrenaux(Date dd, Date df){
		PlageHoraire c = new PlageHoraire(dd, df);
		liste.add(c);
	}
	
	public void updateCrenaux(Date dd, Date df, boolean b) {
		
	}
	
	
	
	
	class PlageHoraire {
		Date dateDebut;
		Date dateFin;
		boolean estReserve;
		
		public PlageHoraire(Date dd, Date df) {
			dateDebut = dd;
			dateFin = df;
			estReserve = false;
		}
		
		public void updatePlage(boolean b) {
			estReserve = b;
		}
	}
	
}
