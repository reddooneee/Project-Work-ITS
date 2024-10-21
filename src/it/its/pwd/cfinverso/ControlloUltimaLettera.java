package it.its.pwd.cfinverso;

import java.util.HashMap;
import java.util.Map;

public class ControlloUltimaLettera{

    public ControlloUltimaLettera(){

    }

    private static final Map<Character, Integer> pari = new HashMap<>();
    private static final Map<Character, Integer> dispari = new HashMap<>();
    private static final String lettere = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static {
        pari.put('0', 0);
        pari.put('1', 1);
        pari.put('2', 2);
        pari.put('3', 3);
        pari.put('4', 4);
        pari.put('5', 5);
        pari.put('6', 6);
        pari.put('7', 7);
        pari.put('8', 8);
        pari.put('9', 9);
        pari.put('A', 0);
        pari.put('B', 1);
        pari.put('C', 2);
        pari.put('D', 3);
        pari.put('E', 4);
        pari.put('F', 5);
        pari.put('G', 6);
        pari.put('H', 7);
        pari.put('I', 8);
        pari.put('J', 9);
        pari.put('K', 10);
        pari.put('L', 11);
        pari.put('M', 12);
        pari.put('N',13);
        pari.put('O', 14);
        pari.put('P', 15);
        pari.put('Q', 16);
        pari.put('R', 17);
        pari.put('S', 18);
        pari.put('T', 19);
        pari.put('U', 20);
        pari.put('V', 21);
        pari.put('W', 22);
        pari.put('X', 23);
        pari.put('Y', 24);
        pari.put('Z', 25);
    }
    
    static {
        dispari.put('0', 1);
        dispari.put('1', 0);
        dispari.put('2', 5);
        dispari.put('3', 7);
        dispari.put('4', 9);
        dispari.put('5', 13);
        dispari.put('6', 15);
        dispari.put('7', 17);
        dispari.put('8', 19);
        dispari.put('9', 21);
        dispari.put('A', 1);
        dispari.put('B', 0);
        dispari.put('C', 5);
        dispari.put('D', 7);
        dispari.put('E', 9);
        dispari.put('F', 13);
        dispari.put('G', 15);
        dispari.put('H', 17);
        dispari.put('I', 19);
        dispari.put('J', 21);
        dispari.put('K', 2);
        dispari.put('L', 4);
        dispari.put('M', 18);
        dispari.put('N', 20);
        dispari.put('O', 11);
        dispari.put('P', 3);
        dispari.put('Q', 6);
        dispari.put('R', 8);
        dispari.put('S', 12);
        dispari.put('T', 14);
        dispari.put('U', 16);
        dispari.put('V', 10);
        dispari.put('W', 22);
        dispari.put('X', 25);
        dispari.put('Y', 24);
        dispari.put('Z', 23);
    }  

    public char calcolaUltimaLettera(String codiceFiscale) {
        codiceFiscale = codiceFiscale.toUpperCase();
        
        int somma = 0;

        for (int i = 0; i < codiceFiscale.length(); i++ ) {
            char carattere = codiceFiscale.charAt(i);
            if (i % 2 != 0) { // Indice pari
               // System.out.println(pari.getOrDefault(carattere, 0));
                somma += pari.getOrDefault(carattere, 0); 
            } 
            else { // Indice dispari
                //System.out.println(dispari.getOrDefault(carattere, 0));
                somma += dispari.getOrDefault(carattere, 0);
                
            }
        }

        // Calcolo del modulo 26
        int indiceLettera = somma % 26;
        return lettere.charAt(indiceLettera);

    }
    
}