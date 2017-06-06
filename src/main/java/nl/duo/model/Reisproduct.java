package nl.duo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
public class Reisproduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;

	@Enumerated(EnumType.STRING)
	SoortReisProduct soortReisProduct;
	
	@Temporal(TemporalType.DATE)
	Date startDatum;
	
	@Temporal(TemporalType.DATE)
	Date eindDatum;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public SoortReisProduct getSoortReisProduct() {
		return soortReisProduct;
	}

	public void setSoortReisProduct(SoortReisProduct soortReisProduct) {
		this.soortReisProduct = soortReisProduct;
	}

	public Date getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}
	
}
