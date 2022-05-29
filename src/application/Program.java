package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner imput = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = imput.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(imput.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(imput.next());

		/* Data de check-Out tem que ser superior a data de check-In */
		/* Testar se a data de check-Out não é posterior check-In */
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out  date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(imput.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(imput.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {/* Testa se a nova data inserida é posterior a antiga entrada de datas */
				System.out.println("Error in reservation: Reservation date for update must be future dates");
			} else if (!checkOut.after(checkIn)) { /* Testar se a data de check-Out não é posterior check-In */
				System.out.println("Error in reservation: check-out  date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		imput.close();
	}
}
