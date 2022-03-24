import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    int shiftValue; // how many spaces to shift right

    ROT13(Character cs, Character cf) {
        Character.toUpperCase(cs);
        Character.toUpperCase(cf);
        int startLocation = findIndexOfCharacterInAlphabet(cs);
        int finishLocation = findIndexOfCharacterInAlphabet(cf);
        shiftValue = finishLocation - startLocation;
    }

    ROT13() {
        shiftValue = 13;
    }

    public String crypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < text.length(); j++) {
            if (Character.isUpperCase(text.charAt(j))) {
                int characterIndexU = findIndexOfCharacterInAlphabet(text.charAt(j));
                int newIndexU = characterIndexU + shiftValue;
                if (newIndexU > 25) {
                    newIndexU -= 25;
                }
                sb.append(alphabetUpper.charAt(newIndexU));
            } else if (Character.isLowerCase(text.charAt(j))) {
                int characterIndexL = findIndexOfCharacterInAlphabet(text.charAt(j));
                int newIndexL = characterIndexL + shiftValue;
                if (newIndexL > 25) {
                    newIndexL -= 25;
                }
                sb.append(alphabetLower.charAt(newIndexL));
            } else if (!Character.isLetterOrDigit(text.charAt(j))) {
                sb.append(text.charAt(j));
            }
        }
        String output = sb.toString();
        System.out.println(output); // TODO - delete
        return output;
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {

        return "";
    }

    public int findIndexOfCharacterInAlphabet(Character c) {
        int index = 0;
        if (Character.isUpperCase(c)) {
            for (int k = 0; k < 26; k++) {
                if (alphabetUpper.charAt(k) == c) {
                    index = k;
                }
            }
        } else {
            for (int l = 0; l < 26; l++) {
                if (alphabetLower.charAt(l) == c) {
                    index = l;
                }
            }
        }
        return index;
    }
}
