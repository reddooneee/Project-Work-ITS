package it.its.pwd.cfinverso;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String codiceFiscale = "";
		System.out.print("Inserisci il codice fiscale: ");
		codiceFiscale = in.nextLine().toUpperCase();
		in.close();

		CodiceFiscaleInverso cfi = new CodiceFiscaleInverso(codiceFiscale);
		cfi.decodifica();
		System.out.println("Cognome: " + cfi.getCognome());
		System.out.println("Nome: " + cfi.getNome());
		System.out.println("Data di Nascita: " + cfi.getDataNascita());
		System.out.println("Sesso: " + cfi.getSesso());
		System.out.println("Comune di Nascita: " + cfi.getComune());

		/* new InterfacciaSwing(); */

	}

}
