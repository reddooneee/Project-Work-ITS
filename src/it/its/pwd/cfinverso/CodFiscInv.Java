package it.its.pwd.cfinverso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodiceFiscaleInverso {
    private String codiceFiscale;
    private String sesso;
    private String comune;

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
    }

    private String estraiCognome(String codice) {
        return codice.replaceAll("[^A-Z]", "");
    }

    private String estraiNome(String codice) {
        return codice.replaceAll("[^A-Z]", "");
    }

    private LocalDate estraiDataNascita(String codice) {
        int anno = Integer.parseInt(codice.substring(0, 2));
        char meseChar = codice.charAt(2);
        int giorno = Integer.parseInt(codice.substring(3, 5));

        if (anno < 40) {
            anno += 2000;
        } else {
            anno += 1900;
        }

        int mese = meseCodici.getOrDefault(meseChar, 1);
        if (giorno > 40) {
            giorno -= 40;
        }

        return LocalDate.of(anno, mese, giorno);
    }

    private String estraiSesso(String codice) {
        int giorno = Integer.parseInt(codice);
        return (giorno > 40) ? "F" : "M";
    }

    private String estraiComune(String codice) {
        try {
            Connection con = Connessione.connectDatabase();
            Statement stmt = con.createStatement();
            String query = "SELECT denominazione_ita FROM gi_comuni WHERE codice_belfiore = '" + codiceFiscale.substring(11, 15) + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //System.out.println("Comune di Nascita: " + rs.getString(1));
                com = rs.getString(1); 

            }

            // con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return com;
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

}  
