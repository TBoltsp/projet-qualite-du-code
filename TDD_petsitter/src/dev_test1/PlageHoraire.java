package dev_test1;

import java.time.LocalDateTime;
import java.util.Objects;

public class PlageHoraire {

	LocalDateTime dateDebut;
	LocalDateTime dateFin;
	boolean estReserve;
	
	public boolean isEstReserve() {
		return estReserve;
	}

	public void setEstReserve(boolean estReserve) {
		this.estReserve = estReserve;
	}

	public PlageHoraire(LocalDateTime dateDebut, LocalDateTime dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		estReserve = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dateFin);
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
