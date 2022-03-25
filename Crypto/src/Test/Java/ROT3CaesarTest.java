import junit.framework.TestCase;
import org.junit.Assert;

import javax.crypto.Cipher;

public class ROT3CaesarTest extends TestCase {

    public void testCrypt() {
        // Given
        ROT3Caesar cipher = new ROT3Caesar();
        String input1 = "ABCDE";
        String expected1 = "DEFGH";
        String input2 = "meredith";
        String expected2 = "phuhglwk";
        String input3 = "HeLlOoOo WORLD!";
        String expected3 = "KhOoRrRr ZRUOG!";
        // When
        String actual1 = cipher.crypt(input1);
        String actual2 = cipher.crypt(input2);
        String actual3 = cipher.crypt(input3);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    public void testEncrypt() {
        // Given
        ROT3Caesar cipher = new ROT3Caesar();
        String input1 = "ABCDE";
        String expected1 = "DEFGH";
        String input2 = "meredith";
        String expected2 = "phuhglwk";
        String input3 = "HeLlOoOo WORLD!";
        String expected3 = "KhOoRrRr ZRUOG!";
        // When
        String actual1 = cipher.crypt(input1);
        String actual2 = cipher.crypt(input2);
        String actual3 = cipher.crypt(input3);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    public void testDecrypt() {
        // Given
        ROT3Caesar cipher = new ROT3Caesar();
        String expected1 = "ABCDE";
        String input1 = "DEFGH";
        String expected2 = "meredith";
        String input2 = "phuhglwk";
        String expected3 = "HeLlOoOo WORLD!";
        String input3 = "KhOoRrRr ZRUOG!";
        // When
        String actual1 = cipher.decrypt(input1);
        // cipher.shiftValue -= (cipher.shiftValue * 2);
        String actual2 = cipher.decrypt(input2);
        // cipher.shiftValue -= (cipher.shiftValue * 2);
        String actual3 = cipher.decrypt(input3);
        // cipher.shiftValue -= (cipher.shiftValue * 2);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    public void testRotate() {
        // Given
        String input = "Zip Code";
        Character inputChar = 'o';
        String expected = "odeZip C";
        // When
        String actual = ROT3Caesar.rotate(input, inputChar);
        // Then
        Assert.assertEquals(expected, actual);
    }

    public void testFindIndexOfCharacterInAlphabet() {
        // Given
        ROT3Caesar cipher = new ROT3Caesar();
        Character aLower = 'a';
        Character mUpper = 'M';
        int expected1 = 0;
        int expected2 = 12;
        // When
        int actual1 = cipher.findIndexOfCharacterInAlphabet(aLower);
        int actual2 = cipher.findIndexOfCharacterInAlphabet(mUpper);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    public void testGenerateNewIndex() {
        // Given
        ROT3Caesar cipher = new ROT3Caesar();
        Character aLower = 'a';
        Character mUpper = 'M';
        int expected1 = 3;
        int expected2 = 15;
        // When
        int actual1 = cipher.generateNewIndex(aLower);
        int actual2 = cipher.generateNewIndex(mUpper);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}