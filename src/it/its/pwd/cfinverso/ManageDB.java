package it.its.pwd.cfinverso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageDB {

    public String getComune(String codicebelfiore) {
        String com = "";
        boolean a = false;
        try {
            Connection con = Connessione.connectDatabase();
            Statement stmt = con.createStatement();
            String query = "SELECT denominazione_ita FROM gi_comuni WHERE codice_belfiore = '"
                    + codicebelfiore + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                com = rs.getString(1);
                a = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (a == false || codicebelfiore.length() != 4) {
            throw new IllegalArgumentException("Codice comune non valido.");
        }
        if (a == false) {
            throw new IllegalArgumentException("Comune non presente.");
        }

        return com;

    }

    public String getCdbelfiore(String comune) {
        String cd = "";
        boolean a = false;
        try {
            Connection con = Connessione.connectDatabase();
            Statement stmt = con.createStatement();
            String query = "SELECT codice_belfiore FROM gi_comuni WHERE denominazione_ita = '"
                    + cd + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                cd = rs.getString(1);
                a = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (a == false || comune.length() != 4) {
            throw new IllegalArgumentException("Codice comune non valido.");
        }
        if (a == false) {
            throw new IllegalArgumentException("Comune non presente.");
        }

        return comune;

    }

}
