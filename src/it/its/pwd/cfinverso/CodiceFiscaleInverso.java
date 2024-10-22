package it.its.pwd.cfinverso;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CodiceFiscaleInverso {
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private LocalDate dataNascita;
    private String sesso;
    private String comune;
    private char carattereControllo;

    private static final Map<Character, Integer> meseCodici = new HashMap<>();

    static {
        meseCodici.put('A', 1);
        meseCodici.put('B', 2);
        meseCodici.put('C', 3);
        meseCodici.put('D', 4);
        meseCodici.put('E', 5);
        meseCodici.put('H', 6);
        meseCodici.put('L', 7);
        meseCodici.put('M', 8);
        meseCodici.put('P', 9);
        meseCodici.put('R', 10);
        meseCodici.put('S', 11);
        meseCodici.put('T', 12);
    }

    public CodiceFiscaleInverso(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }

        this.codiceFiscale = codiceFiscale;
    }

    public void decodifica() {
        cognome = estraiCognome(codiceFiscale.substring(0, 3));
        nome = estraiNome(codiceFiscale.substring(3, 6));
        dataNascita = estraiDataNascita(codiceFiscale.substring(6, 11));
        sesso = estraiSesso(codiceFiscale.substring(9, 11));
        comune = estraiComune(codiceFiscale.substring(11, 15));
        carattereControllo = calcolaCarattereControllo(codiceFiscale);
;
    }

    private String estraiCognome(String codice) {
        if (codice == null || codice.length() != 3) {
            throw new IllegalArgumentException("Il cognome contiene caratteri non alfabetici.");
        } else {
            codice = codice.replaceAll("[^A-Z]", "");
        }
        if (codice.length() != 3) {
            throw new IllegalArgumentException("Il cognome contiene caratteri non alfabetici.");
        }
        return codice.toUpperCase();
    }

    private String estraiNome(String codice) {
        if (codice == null || codice.length() != 3) {
            throw new IllegalArgumentException("Il nome contiene caratteri non alfabetici.");
        } else {
            codice = codice.replaceAll("[^A-Z]", "");
        }
        if (codice.length() != 3) {
            throw new IllegalArgumentException("Il nome contiene caratteri non alfabetici.");
        }
        return codice.toUpperCase();
    }

    private LocalDate estraiDataNascita(String codice) {
        try {
            int anno = Integer.parseInt(codice.substring(0, 2));
            char meseChar = codice.charAt(2);
            int giorno = Integer.parseInt(codice.substring(3, 5));

            Integer mese = meseCodici.get(meseChar);
            if (mese == null) {
                throw new IllegalArgumentException("Mese non valido nel codice fiscale: " + meseChar);
            }

            if (anno < 40) {
                anno += 2000;
            } else {
                anno += 1900;
            }
 
            if (giorno > 31) {
                giorno -= 40; // Sottrai 40 per ottenere il giorno corretto
            }

            return LocalDate.of(anno, mese, giorno);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Formato della data di nascita errato.");
        } catch (DateTimeException e) {
            throw new DateTimeException("Data di nascita non valida: " + e.getMessage());
        }
    }

    private String estraiSesso(String codice) {
        try {
            int giorno = Integer.parseInt(codice.substring(0, 2));
            return (giorno > 31) ? "F" : "M";
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Codice non valido per il sesso.");
        }
    }

    private String estraiComune(String codice) {
        String result = "";
        ManageDB manageDB = new ManageDB();
        result = manageDB.getComune(codiceFiscale.substring(11, 15));
        return result;
    }

    private static char calcolaCarattereControllo(String codiceFiscale) {
        ControlloUltimaLettera controllo = new ControlloUltimaLettera();

        try {
            char codice = controllo.calcolaUltimaLettera(codiceFiscale.substring(0, 15));
            char ultimaLettera = codiceFiscale.substring(15, 16).charAt(0);
          //  System.out.println(codice + ultimaLettera);
            if(codice != ultimaLettera){
                throw new IllegalArgumentException("Ultimo carattere del codice fiscale incorretto.");
            }
            return codice;
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Errore nel calcolo del carattere di controllo: " + e.getMessage());
            throw e;
        }
    }  

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascita() {
        return dataNascita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getSesso() {
        return sesso;
    }

    public String getComune() {
        return comune;

    }

    public char getCalcolaCarattereControllo() {
        return carattereControllo;
    }
}
