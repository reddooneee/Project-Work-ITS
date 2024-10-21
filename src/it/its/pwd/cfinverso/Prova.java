package it.its.pwd.cfinverso;

//import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/* 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
*/
public class Prova {
    public void prova() {
        /*
         * JFrame frame = new JFrame("Frame");
         * JPanel panel = new JPanel();
         * 
         * DefaultTableModel tab = new DefaultTableModel();
         * JTable tabella = new JTable(tab);
         * 
         * tab.addColumn("1");
         * tab.addColumn("2");
         * tab.addColumn("3");
         * tab.addColumn("4");
         * tab.addColumn("5");
         * 
         * panel.add(tabella);
         * panel.setBackground(Color.green);
         * panel.setBounds(0, 300, 750, 100);
         * 
         * frame.add(panel);
         * frame.setBounds(400, 200, 750, 385);
         * //frame.setVisible(true);
         */

        try {
            Connection con = Connessione.connectDatabase();
            Statement stmt = con.createStatement();

            Scanner in = new Scanner(System.in);
            System.out.print("Inserisci la citta: ");
            String citta= in.nextLine().toUpperCase();

            String query = "SELECT codice_belfiore FROM gi_comuni WHERE denominazione_ita = '" + citta + "'";
            ResultSet rs = stmt.executeQuery(query);
            in.close();
            while (rs.next()) {
                System.out.println("Comune di Nascita: " + rs.getString(1));
            }

            // con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        /*
         * Scanner in = new Scanner(System.in);
         * String codiceFiscale = "";
         * System.out.print("Inserisci il codice fiscale: ");
         * codiceFiscale = in.nextLine().toUpperCase();
         * in.close();
         * System.out.println("Comune di Nascita: " + " ");
         */
        Prova p = new Prova();
        p.prova();

    }

}