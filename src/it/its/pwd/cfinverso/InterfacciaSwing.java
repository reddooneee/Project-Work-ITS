package it.its.pwd.cfinverso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class InterfacciaSwing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoCodiceFiscale; // Campo per l'inserimento del codice fisale
    private JTextArea areaRisultato; // Area Dove ricevo il risultato del codice fiscale codificato

    public InterfacciaSwing() {
        super("Decodifica Codice Fiscale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Pannello superiore
        JPanel pannelloSuperiore = new JPanel();
        pannelloSuperiore.setLayout(new FlowLayout());

        JLabel labelCodiceFiscale = new JLabel("Codice Fiscale:");
        campoCodiceFiscale = new JTextField(30);

        JButton pulsanteDecodifica = new JButton("Decodifica");
        pulsanteDecodifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decodificaCodiceFiscale();
            }
        });

        /*
         * Prova Stile Bordo Pulsante
         * pulsanteDecodifica.setBorder(BorderFactory.createLineBorder(Color.black));
         * pulsanteDecodifica.setBorder(new round(10));
         */

        labelCodiceFiscale.setForeground(Color.BLUE); // Set label text color to blue
        campoCodiceFiscale.setPreferredSize(new Dimension(250, 30)); // Set preferred size to make the field large
        //
        // campoCodiceFiscale.setPreferredSize(44, 44);

        // Imposta un bordo rotondo
        pulsanteDecodifica.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 2), // Bordo esterno
                new EmptyBorder(5, 5, 5, 5) // Spazio interno
        ));

        // Imposta il colore di sfondo trasparente
        pulsanteDecodifica.setContentAreaFilled(false);
        pulsanteDecodifica.setFocusPainted(false);

        pannelloSuperiore.add(labelCodiceFiscale);
        pannelloSuperiore.add(campoCodiceFiscale);
        pannelloSuperiore.add(pulsanteDecodifica);

        // Pannello inferiore
        JPanel pannelloInferiore = new JPanel();
        pannelloInferiore.setLayout(new BorderLayout());

        areaRisultato = new JTextArea(10, 30);
        areaRisultato.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaRisultato);

        pannelloInferiore.add(scrollPane, BorderLayout.CENTER);

        // Aggiungi pannelli alla finestra
        add(pannelloSuperiore, BorderLayout.NORTH);
        add(pannelloInferiore, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private void decodificaCodiceFiscale() {
        String codiceFiscale = campoCodiceFiscale.getText().toUpperCase();

        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            JOptionPane.showMessageDialog(this, "Codice fiscale non valido");
            return;
        }

        CodiceFiscaleInverso cfi = new CodiceFiscaleInverso(codiceFiscale);

        try {
            cfi.decodifica();

            StringBuilder risultato = new StringBuilder();
            risultato.append("Cognome: ").append(cfi.getCognome()).append("\n");
            risultato.append("Nome: ").append(cfi.getNome()).append("\n");
            risultato.append("Data di Nascita: ").append(cfi.getDataNascita()).append("\n");
            risultato.append("Sesso: ").append(cfi.getSesso()).append("\n");
            risultato.append("Comune di Nascita: ").append(cfi.getComune()).append("\n");

            areaRisultato.setText(risultato.toString());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /*
     * public static void main(String[] args) {
     * new InterfacciaSwing();
     * }
     */
}