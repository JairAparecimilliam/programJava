package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
		super();
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {

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
