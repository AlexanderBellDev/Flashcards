import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalAlphabet = scanner.nextLine();
        String resultingAlphabet = scanner.nextLine();
        String lineToEncrypt = scanner.nextLine();
        String lineToDecrypt = scanner.nextLine();

        HashMap<String, String> encryptionHashmap = new HashMap<>();
        HashMap<String, String> decryptionHashmap = new HashMap<>();
        String[] originalAlphabetArray = originalAlphabet.split("");
        String[] resultingAlphabetArray = resultingAlphabet.split("");
        for (int i = 0; i < originalAlphabetArray.length; i++) {
            encryptionHashmap.put(originalAlphabetArray[i], resultingAlphabetArray[i]);
            decryptionHashmap.put(resultingAlphabetArray[i], originalAlphabetArray[i]);
        }

        String[] lineToEncryptArray = lineToEncrypt.split("");
        for (String s : lineToEncryptArray) {
            System.out.print(encryptionHashmap.get(s));
        }
        System.out.println();

        String[] lineToDecryptArray = lineToDecrypt.split("");
        for (String s : lineToDecryptArray) {
            System.out.print(decryptionHashmap.get(s));
        }

    }
}