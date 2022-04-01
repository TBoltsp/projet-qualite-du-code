package testing;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

public class PlageHoraire {
		LocalDateTime dateDebut;
		LocalDateTime dateFin;
		boolean estReserve;
		
		public PlageHoraire(LocalDateTime dd, LocalDateTime df) {
			dateDebut = dd;
			dateFin = df;
			estReserve = false;
		}
		public PlageHoraire(LocalDateTime dd, LocalDateTime df,boolean b) {
			dateDebut = dd;
			dateFin = df;
			estReserve = b;
		}
		
		public void updatePlage(boolean b) {
			estReserve = b;
		}
		
		public boolean getEstReserve() {
			return estReserve;
		}
		
		
	}
