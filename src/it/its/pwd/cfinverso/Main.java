package it.its.pwd.cfinverso;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean b = true;

		while (b) {
			System.out.println("\n\tCodice Fiscale");
			System.out.println("\t1. Nuovo Codice Fiscale");
			System.out.println("\tQualunque altra scelta il programma si chiuderà");
			System.out.print("\tScelta: ");
			String scelta = in.nextLine();
			if (scelta.equals("1")) {
				String codiceFiscale = "";
				System.out.print("\tInserisci il codice fiscale: ");
				codiceFiscale = in.nextLine().toUpperCase();

				CodiceFiscaleInverso cfi = new CodiceFiscaleInverso(codiceFiscale);
				cfi.decodifica();
				System.out.println("\tCognome: " + cfi.getCognome());
				System.out.println("\tNome: " + cfi.getNome());
				System.out.println("\tData di Nascita: " + cfi.getDataNascita());
				System.out.println("\tSesso: " + cfi.getSesso());
				System.out.println("\tComune di Nascita: " + cfi.getComune());
				System.out.println("\tCarattere di controllo: " + cfi.getCalcolaCarattereControllo());

			} else {
				b = false;
				System.out.print("\tProgramma terminato");
			}
		}
		/* new InterfacciaSwing(); */

	}

}
