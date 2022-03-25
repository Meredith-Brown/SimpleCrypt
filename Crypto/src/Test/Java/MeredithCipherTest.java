import junit.framework.TestCase;
import org.junit.Assert;

public class MeredithCipherTest extends TestCase {

    public void testCrypt() {
        // Given
        MeredithCipher cipher = new MeredithCipher();
        String input1 = "ABCDE";
        String expected1 = "BCDEN";
        String input2 = "meredith";
        String expected2 = "ansnejui";
        String input3 = "hi WORLD!";
        String expected3 = "ij XPSME!";
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
        MeredithCipher cipher = new MeredithCipher();
        String input1 = "ABCDE";
        String expected1 = "BCDEN";
        String input2 = "meredith";
        String expected2 = "ansnejui";
        String input3 = "hi WORLD!";
        String expected3 = "ij XPSME!";
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
        MeredithCipher cipher = new MeredithCipher();
        String expected1 = "ABCDE";
        String input1 = "BCDEN";
        String expected2 = "meredith";
        String input2 = "ansnejui";
        String expected3 = "hi WORLD!";
        String input3 = "ij XPSME!";
        // When
        String actual1 = cipher.decrypt(input1);
        String actual2 = cipher.decrypt(input2);
        String actual3 = cipher.decrypt(input3);
        // Then
        Assert.assertEquals (expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    public void testFindIndexOfCharacterInAlphabet() {
        // Given
        MeredithCipher cipher = new MeredithCipher();
        Character aLower = 'a';
        Character mUpper = 'M';
        int expected1 = 8;
        int expected2 = 7;
        // When
        int actual1 = cipher.findIndexOfCharacterInAlphabet(aLower);
        int actual2 = cipher.findIndexOfCharacterInAlphabet(mUpper);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    public void testGenerateNewIndex() {
        MeredithCipher cipher = new MeredithCipher();
        Character aLower = 'a';
        Character mUpper = 'M';
        Character eLower = 'e';
        Character zUpper = 'Z';
        int expected1 = 9;
        int expected2 = 8;
        int expected3 = 13;
        int expected4 = 0;
        // When
        int actual1 = cipher.generateNewIndex(aLower);
        int actual2 = cipher.generateNewIndex(mUpper);
        int actual3 = cipher.generateNewIndex(eLower);
        int actual4 = cipher.generateNewIndex(zUpper);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }
}