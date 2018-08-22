package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 1, allocationSize = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "id_reservation")
	private Long id_reservation;
	@Column(name = "date")
	private Date date;
	@Column(name = "numero")
	private Long numero;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;
	
	@ManyToOne
	@JoinColumn(name = "id_passager")
	private Passager passager;

	public Reservation() {
		super();
	}

	public Reservation(Date date, Long numero) {
		super();
		this.date = date;
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id_reservation;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id_reservation == null) ? 0 : id_reservation.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_reservation == null) {
			if (other.id_reservation != null)
				return false;
		} else if (!id_reservation.equals(other.id_reservation))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}
