package it.its.pwd.cfinverso;

import java.util.HashMap;
import java.util.Map;

public class ControlloUltimaLettera{

    private static Integer A;

    public ControlloUltimaLettera(){

    }

    private static final Map<Character, Integer> pari = new HashMap<>();
    private static final Map<Character, Integer> dispari = new HashMap<>();
    private static final Map<Integer, Character>  lettere = new HashMap<>();
    //private static final String lettere = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
        pari.put('K', 0);
        pari.put('L', 1);
        pari.put('M', 2);
        pari.put('N', 3);
        pari.put('O', 4);
        pari.put('P', 5);
        pari.put('Q', 6);
        pari.put('R', 7);
        pari.put('S', 8);
        pari.put('T', 9);
        pari.put('U', 0);
        pari.put('V', 1);
        pari.put('W', 2);
        pari.put('X', 3);
        pari.put('Y', 4);
        pari.put('Z', 5);
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
      

static{
            for (int i = 0; i < 26; i++) {
                lettere.put(i, (char) ('A' + i));
            }
        }

        public char calcolaUltimaLettera(String codiceFiscale) {
            codiceFiscale = codiceFiscale.toUpperCase();
            int somma = 0;
    
            for (int i = 0; i < codiceFiscale.length() - 1; i++) {
                char carattere = codiceFiscale.charAt(i);
                if (i % 2 == 0) {
                    somma += pari.getOrDefault(carattere, 0);
                } else {
                    somma += dispari.getOrDefault(carattere, 0);
     }
            }
    
            int indiceLettera = somma % 26;
            return lettere.get(indiceLettera);
        }
}