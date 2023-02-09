package testing;

import java.io.*;
import java.util.*;


public class Test {

    public static void main(String[] args) {

        ArrayList<String> sentenses = new ArrayList<String>();
        sentenses.add("/**** ZOZNAM VIET ****/");

        Skratky skr = new Skratky();
        boolean slovnik = false;

        int sentense_last_char = 0;
        int word_last_char = 0;
        String word = "";
        String input;
        String next_line = "";

        try {
            BufferedReader bR = new BufferedReader(new FileReader("JavaText.txt"));

            while((input = bR.readLine()) != null) {

                input = next_line + " " + input;

                sentense_last_char = 0;
                word_last_char = 0;

                for (int i = 1; i < input.length() - 3; i++) {
                    String ch = input.substring(i, i + 3);

//            vytvaranie slov
                    if (input.charAt(i + 2) == ' ') {
                        word = input.substring(word_last_char, i + 2).trim().toLowerCase();
                        word_last_char = i + 3;
                        slovnik = skr.dictionary(word);
                    }

//          delenie textu na vety

//          teraz sa deli text, ked konci veta cislovkou ale nemože sa začínať. Ak chceš aby sa mohla začínať, tak pridaj toto do podmienky.
//          && (input.substring(i-1,i).matches("[a-z]")
                    if ((ch.matches("([!?.])(\\s)[A-Z]")) && !slovnik ) {
                        sentenses.add(input.substring(sentense_last_char, i + 1));
                        sentense_last_char = i + 1;
                    }
                }

                next_line = input.substring(sentense_last_char, input.length()).trim();
            }
            sentenses.add(next_line);
            sentenses.add("/*** KONIEC ZOZNAMU VIET ***/");

            for (String part : sentenses) {
                System.out.println(part.trim());
            }
        }catch (IOException e){
            System.out.println("Chyba suboru");
        }







    }

    }

