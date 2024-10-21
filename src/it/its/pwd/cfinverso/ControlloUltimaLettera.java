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
        pari.put('A', 10);
        pari.put('B', 11);
        pari.put('C', 12);
        pari.put('D', 13);
        pari.put('E', 14);
        pari.put('F', 15);
        pari.put('G', 16);
        pari.put('H', 17);
        pari.put('I', 18);
        pari.put('J', 19);
        pari.put('K', 20);
        pari.put('L', 21);
        pari.put('M', 22);
        pari.put('N', 23);
        pari.put('O', 24);
        pari.put('P', 25);
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
        dispari.put('K', 1);
        dispari.put('L', 0);
        dispari.put('M', 5);
        dispari.put('N', 7);
        dispari.put('O', 9);
        dispari.put('P', 13);
        dispari.put('Q', 15);
        dispari.put('R', 17);
        dispari.put('S', 19);
        dispari.put('T', 21);
        dispari.put('U', 1);
        dispari.put('V', 0);
        dispari.put('W', 5);
        dispari.put('X', 7);
        dispari.put('Y', 9);
        dispari.put('Z', 13);
    }  

    public char calcolaUltimaLettera(String codiceFiscale) {
        codiceFiscale = codiceFiscale.toUpperCase();
        
        int somma = 0;

        for (int i = 0; i < codiceFiscale.length(); i++) {
            char carattere = codiceFiscale.charAt(i);
            if (i % 2 == 0) { // Indice pari
                somma += pari.getOrDefault(carattere, 0);
            } 
            else { // Indice dispari
                somma += dispari.getOrDefault(carattere, 0);
            }
        }

        // Calcolo del modulo 26
        int indiceLettera = somma % 26;
        return lettere.charAt(indiceLettera);
    }
    
}