
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MorseCodeConverter class converts Morse code to English
 * 
 * @author Andrew Chiaramonte
 * @date 11/1/2023
 */
public class MorseCodeConverter {

    private static MorseCodeTree tree = new MorseCodeTree();

    MorseCodeConverter() {
    }

    /**
     * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
     * Each word is delimited by a ‘/’.
     * Example:
     * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     * 
     * @param morseCode The morse code to convert
     * @return The English translation of the morse code
     */
    public static String convertToEnglish(String morseCode) {
        String[] letter;
        // split code into words
        String[] singleWord = morseCode.split(" / ");
        StringBuilder english = new StringBuilder();

        for (String character : singleWord) {
            letter = character.split(" ");
            for (String tempVar : letter) {
                english.append(tree.fetch(tempVar));
            }
            english.append(" ");
        }
        return english.toString().trim();
    }

    /**
     * Converts a file of Morse code into English Each letter is delimited by a
     * space (‘ ‘). Each word is delimited by a ‘/’.
     * Example:
     * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
     * string returned = "Hello World"
     * 
     * @param codeFile the code file
     * @return the string
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(java.io.File codeFile) throws FileNotFoundException {
        String morseCode = "";
        Scanner fileScanner = new Scanner(codeFile);
        while (fileScanner.hasNext()) {
            morseCode += fileScanner.nextLine();
        }
        fileScanner.close();
        return convertToEnglish(morseCode);
    }

    /**
     * returns a string with all the data in the tree in LNR order with an space in
     * between them. Uses the toArrayList method in MorseCodeTree It should return
     * the data in this order:
     * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * Note the extra space between j and b - that is because there is an empty
     * string that is the root, and in the LNR traversal, the root would come
     * between the right most child of the left tree (j) and the left most child of
     * the right tree (b). This is used for testing purposes to make sure the
     * MorseCodeTree has been built properly
     * 
     * @return String the data in the tree in LNR order separated by a space.
     */
    public static String printTree() {
        ArrayList<String> morseCodeTree = tree.toArrayList();
        StringBuilder string = new StringBuilder();

        for (String letters : morseCodeTree) {
            string.append(letters).append(" ");
        }
        return string.toString().trim();
    }

}
