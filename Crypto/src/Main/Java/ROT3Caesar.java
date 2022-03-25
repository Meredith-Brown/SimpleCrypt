// The Caesar cipher is named after Julius Caesar, who, according to Suetonius, used it with a
// shift of three (A becoming D when encrypting, and D becoming A when decrypting) to protect
// messages of military significance.

public class ROT3Caesar extends ROT13 {

    ROT3Caesar() {
        shiftValue = 3;
    }

}
