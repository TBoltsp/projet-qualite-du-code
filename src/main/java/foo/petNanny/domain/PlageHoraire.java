package foo.petNanny.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class PlageHoraire {
	
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private boolean estReserve;

	public PlageHoraire(LocalDateTime dd, LocalDateTime df) {
		if (dd.isAfter(df)) {
			throw new IllegalArgumentException("date debut doit etre inferieur a date fin");
		}
		dateDebut = dd;
		dateFin = df;
		estReserve = false;
	}

	public boolean collision(PlageHoraire ph) {
		return dateDebut.isAfter(ph.getDateDebut()) && dateFin.isAfter(ph.getDateFin()) && dateDebut.isBefore(ph.getDateFin())
				|| dateDebut.isBefore(ph.getDateDebut()) && dateFin.isBefore(ph.getDateFin()) && dateFin.isAfter(ph.getDateDebut())
				|| dateDebut.isAfter(ph.getDateDebut()) && dateFin.isBefore(ph.getDateFin()) 
				|| dateDebut.isBefore(ph.getDateDebut()) && dateFin.isAfter(ph.getDateFin());
	}

	private LocalDateTime getDateFin() {
		return dateFin;
	}

	private LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setEstReserve(boolean b) {
		this.estReserve = b;
	}
	
	public boolean getEstReserve() {
		return estReserve;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageHoraire other = (PlageHoraire) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin);
	}
	
	
}
