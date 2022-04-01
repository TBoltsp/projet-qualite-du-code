package testing;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendrier {

	ArrayList<PlageHoraire> liste;
	
	public Calendrier() {
		liste = new ArrayList<>();
	}
	
	public void ajoutCrenaux(LocalDateTime localDateTime, LocalDateTime localDateTime2){
		PlageHoraire c = new PlageHoraire(localDateTime, localDateTime2);
		liste.add(c);
	}
	
	public void updateCrenaux(LocalDateTime dd, LocalDateTime df, boolean b) throws IllegalArgumentException {
		PlageHoraire ph = new PlageHoraire(dd,df);
		if (liste.contains(ph)) {
			PlageHoraire calPH = getCreneaux(ph);
			if (calPH.getEstReserve()) {
				throw new IllegalArgumentException("Creneaux déja réservé");
			}
			calPH.updatePlage(true);
		}
		throw new IllegalArgumentException("Creneaux indisponible");
	}

	private PlageHoraire getCreneaux(PlageHoraire ph) {
		return liste.get(liste.indexOf(ph));
	}
	
	
	
	
	
	
}
