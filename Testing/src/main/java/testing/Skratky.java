package testing;

public class Skratky {
    String[] abbreviations_dictionary = {"mgr.", "phd.", "mudr."};

    public boolean dictionary(String word) {
        for (String s : abbreviations_dictionary) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }



}
