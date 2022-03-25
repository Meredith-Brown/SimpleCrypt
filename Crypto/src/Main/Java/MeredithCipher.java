public class MeredithCipher {
    String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    int shiftValue = 10; // shift value for all letters EXCEPT 'M', 'E', 'R', 'D', 'I', 'T', 'H'
    int secondShiftValue = 2; // shift value for 'M', 'E', 'R', 'D', 'I', 'T', 'H'

    MeredithCipher() {}

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

    public String decrypt(String text) { // TODO
        shiftValue -= (shiftValue * 2);
        text = crypt(text);
        shiftValue -= (shiftValue * 2); // revert
        return text;
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

    public int generateNewIndex(Character c) {
        int characterIndex = findIndexOfCharacterInAlphabet(c);
        int newIndex = 0;
        if (characterIndex == 12 || characterIndex == 4 || characterIndex == 17 || characterIndex == 3 ||
                characterIndex == 8 || characterIndex == 19 || characterIndex == 7) {
            newIndex = characterIndex + secondShiftValue;
        } else {
            newIndex = characterIndex + shiftValue;
            if (newIndex > 25) {
                newIndex -= 26;
            }
            if (newIndex < 0) {
                newIndex += 26;
            }
        }
        return newIndex;
    }
}
