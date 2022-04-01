package testing;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.BooleanSupplier;

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
		public BooleanSupplier collision(PlageHoraire ph2) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
