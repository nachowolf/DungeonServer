package ciphers;

import java.util.HashMap;
import java.util.Map;

public class Atbash implements Cipher {

    static private Map<String, String> alphabet = new HashMap<>();

    static {
        alphabet.put("A", "Z");
        alphabet.put("B", "Y");
        alphabet.put("C", "X");
        alphabet.put("D", "W");
        alphabet.put("E", "V");
        alphabet.put("F", "U");
        alphabet.put("G", "T");
        alphabet.put("H", "S");
        alphabet.put("I", "R");
        alphabet.put("J", "Q");
        alphabet.put("K", "P");
        alphabet.put("L", "O");
        alphabet.put("M", "N");
        alphabet.put("N", "M");
        alphabet.put("O", "L");
        alphabet.put("P", "K");
        alphabet.put("Q", "J");
        alphabet.put("R", "I");
        alphabet.put("S", "H");
        alphabet.put("T", "G");
        alphabet.put("U", "F");
        alphabet.put("V", "E");
        alphabet.put("W", "D");
        alphabet.put("X", "C");
        alphabet.put("Y", "B");
        alphabet.put("Z", "A");

    }

    @Override
    public String encrypt(String input) {
       StringBuilder builder = new StringBuilder();
       String[] rawText = input.split("");

       for(String letter : rawText){

              if(alphabet.containsKey(letter.toUpperCase())){
                  builder.append(alphabet.get(letter.toUpperCase()));
              }
              else{
                  builder.append(letter);
              }
          }
       return builder.toString().trim();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder builder = new StringBuilder();
        String[] rawText = input.split("");

        for (String letter : rawText) {

            if (alphabet.containsKey(letter.toUpperCase())) {
                builder.append(alphabet.get(letter.toUpperCase()));
            } else {
                builder.append(letter);
            }
        }
        return builder.toString().trim();
    }
}
