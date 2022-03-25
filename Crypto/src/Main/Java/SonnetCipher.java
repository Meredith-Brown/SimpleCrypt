import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class SonnetCipher {
    public static boolean same = false;

    public static boolean sonnetCipherTest() {
        String sonnet = null;
        try {
            sonnet = importSonnet("/Users/meredith/dev/SimpleCrypt/sonnet18.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String encryptedSonnet = encryptSonnet(sonnet);
        try {
            exportEncryptedSonnet(encryptedSonnet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sonnetToDecrypt = null;
        try {
            sonnetToDecrypt = importSonnet("/Users/meredith/dev/SimpleCrypt/sonnet18.enc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String decryptedSonnet = encryptSonnet(sonnetToDecrypt);
        System.out.println(decryptedSonnet);
        same = (sonnet == decryptedSonnet);
        System.out.println(same);
        return same;
    }

    public static String importSonnet(String pathname) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File sonnetFile = new File(pathname);
        Scanner scanner = new Scanner(sonnetFile);
        sb.append(scanner.nextLine());
        while (scanner.hasNextLine()) {
            sb.append("\n");
            sb.append(scanner.nextLine());
        }
        scanner.close();
        String sonnet = sb.toString();
        return sonnet;
    }

    public static String encryptSonnet(String sonnet) {
        ROT13 cipher = new ROT13();
        String encryptedSonnet = cipher.crypt(sonnet);
        return encryptedSonnet;
    }

    public static void exportEncryptedSonnet(String encryptedSonnet) throws IOException {
        File encryptedSonnetFile = new File("/Users/meredith/dev/SimpleCrypt/sonnet18.enc");
        encryptedSonnetFile.createNewFile();
        FileWriter writer = new FileWriter("/Users/meredith/dev/SimpleCrypt/sonnet18.enc");
        writer.write(encryptedSonnet);
        writer.close();
    }
}