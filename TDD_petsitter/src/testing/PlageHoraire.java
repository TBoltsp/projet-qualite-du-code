package testing;
import java.sql.Date;
import java.util.Objects;

public class PlageHoraire {
		Date dateDebut;
		Date dateFin;
		boolean estReserve;
		
		public PlageHoraire(Date dd, Date df) {
			dateDebut = dd;
			dateFin = df;
			estReserve = false;
		}
		public PlageHoraire(Date dd, Date df,boolean b) {
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
