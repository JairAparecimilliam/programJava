package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
		super();
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		 if (!checkOut.after(checkIn)) { /* Testar se a data de check-Out não é posterior check-In */
				throw new DomainException("Check-out  date must be after check-in date");
			}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// diferença das DATAS em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// como converter milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	// Recebe duas novas datas e atualiza checkIn e checkOut
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut. before(now)) {/* Testa se a nova data inserida é posterior a antiga entrada de datas */
			throw new DomainException("Reservation date for update must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("CHeck-out date must be after check-in date");
		} 
        this.checkIn = checkIn;
		this.checkOut = checkOut;
		}

	@Override
	public String toString() {
		return "Room:  " 
	+ roomNumber 
	+ ", check-In: " 
	+ sdf.format(checkIn) 
	+ ", check-Out: " 
	+ sdf.format(checkOut)
    + ", " 
	+ duration() 
	+ " nights";
	}
}
