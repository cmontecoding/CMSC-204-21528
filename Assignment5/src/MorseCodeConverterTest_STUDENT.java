
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class MorseCodeConverterTest_STUDENT {

    

    /**
     * Testing for correct implementation of tree and traversal
     */
    @Test
    public void testConvertToEnglishString() {
        String converter1 = MorseCodeConverter.convertToEnglish(".... .. / -.-- --- ..- ");
        assertEquals("hi you", converter1);
    }

    @Test
    public void testConvertMorseFileToEnglishString() {

        /*
         * Make sure howDoILoveThee.txt is in the src directory for this
         * test to pass
         */
        File file = new File("src/LoveLooksNot.txt");
        try {
            assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file));
        } catch (FileNotFoundException e) {
            assertTrue("An unwanted exception was caught", false);
        }
    }

}
