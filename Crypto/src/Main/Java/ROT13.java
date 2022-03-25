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
                int newIndexU = generateNewIndex(text.charAt(j));
                sb.append(alphabetUpper.charAt(newIndexU));
            } else if (Character.isLowerCase(text.charAt(j))) {
                int newIndexL = generateNewIndex(text.charAt(j));
                sb.append(alphabetLower.charAt(newIndexL));
            } else if (!Character.isLetterOrDigit(text.charAt(j))) {
                sb.append(text.charAt(j));
            }
        }
        String output = sb.toString();
        return output;
    }

    public String encrypt(String text) {
        text = crypt(text);
        return text;
    }

    public String decrypt(String text) {
        shiftValue -= (shiftValue * 2);
        text = crypt(text);
        shiftValue -= (shiftValue * 2); // revert
        return text;
    }

    public static String rotate(String s, Character c) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == c) {
                index = k;
            }
        }
        for (int z = index; z < s.length(); z++) {
            sb.append(s.charAt(z));
        }
        for (int y = 0; y < index; y++) {
            sb.append(s.charAt(y));
        }
        String output = sb.toString();
        return output;
    }

    public int findIndexOfCharacterInAlphabet(Character c) { // added/tested
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

    public int generateNewIndex(Character c) { // added/tested
        int characterIndex = findIndexOfCharacterInAlphabet(c);
        int newIndex = characterIndex + shiftValue;
        if (newIndex > 25) {
            newIndex -= 26;
        }
        if (newIndex < 0) {
            newIndex += 26;
        }
        return newIndex;
    }
}
