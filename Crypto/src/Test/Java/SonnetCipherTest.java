import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class SonnetCipherTest extends TestCase {

    public void testImportSonnet() throws FileNotFoundException {
        // Given
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.";
        // When
        String actual = SonnetCipher.importSonnet("/Users/meredith/dev/SimpleCrypt/sonnet18.txt");
        // Then
        Assert.assertEquals(expected, actual);
    }

    public void testEncryptSonnet() throws FileNotFoundException {
        // Given
        Character expected1 = 'F';
        Character expected2 = 'u';
        Character expected3 = 'n';
        Character expected4 = 'y';
        Character expected5 = 'y';
        Character expected6 = ' ';
        Character expected7 = 'V';
        String sonnet = SonnetCipher.importSonnet("/Users/meredith/dev/SimpleCrypt/sonnet18.txt");
        // When
        String encryptedSonnet = SonnetCipher.encryptSonnet(sonnet);
        Character actual1 = encryptedSonnet.charAt(0);
        Character actual2 = encryptedSonnet.charAt(1);
        Character actual3 = encryptedSonnet.charAt(2);
        Character actual4 = encryptedSonnet.charAt(3);
        Character actual5 = encryptedSonnet.charAt(4);
        Character actual6 = encryptedSonnet.charAt(5);
        Character actual7 = encryptedSonnet.charAt(6);
        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
        Assert.assertEquals(expected5, actual5);
        Assert.assertEquals(expected6, actual6);
        Assert.assertEquals(expected7, actual7);

    }

    public void testSonnetCipherTest() {
        boolean expected = true;
        boolean actual = SonnetCipher.sonnetCipherTest();
        Assert.assertEquals(expected, actual);

    }
}