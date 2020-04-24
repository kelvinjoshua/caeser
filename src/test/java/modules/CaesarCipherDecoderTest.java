package modules;
import models.CaesarCipherDecoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class CaesarCipherDecoderTest {
    @Test
    public void newCaesarCipherObject_instantiatesCorrectly() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder = new CaesarCipherDecoder("A", 1);
        assertTrue(true);
    }

    @Test
    public void newCaesarCipherDecoder_getUserText_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder = new CaesarCipherDecoder("", 1);
        assertEquals("", testCaesarCipherDecoder.getUserText());
    }

    @Test
    public void newCaesarCipherDecoder_getUserShiftKey_int() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder = new CaesarCipherDecoder("", 0);
        assertEquals(0, testCaesarCipherDecoder.getUserKey());
    }

    @Test
    public void decodeUserText_decodesOneLetterString_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder("D", 1);
        assertEquals("C", testCaesarCipherDecoder.decodeUserText());
    }

    @Test
    public void decodesUserText_decodesTwoLetterString_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder("TH", 1);
        assertEquals("SG", testCaesarCipherDecoder.decodeUserText());
    }

    @Test
    public void decodesUserText_decodesMultipleLetterString_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder("YOLTKCLU", 23);
        assertEquals("BROWNFOX", testCaesarCipherDecoder.decodeUserText());
    }

    @Test
    public void decodesUserText_decodesStringWithDifferentAlphabeticalCaseLetters_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder(
                "VyyuEZdkLVOC", 10);
        assertEquals("LookUPtaBLES", testCaesarCipherDecoder.decodeUserText());
    }

    @Test
    public void decodeUserText_decodesStringWithASpaceInBetweenTwoStrings_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder(
                "Olr OLR", 13);
        assertEquals("Bye BYE", testCaesarCipherDecoder.decodeUserText());
    }
    @Test
    public void decodeUserText_decodesStringWithMultipleWordsWithSpacesAndSpecialCharacters_String() throws Exception {
        CaesarCipherDecoder testCaesarCipherDecoder=new CaesarCipherDecoder("1. Pbjxyf%Pmjymnqj Pmjymnqj ky. @Rfpbf", 5);
        assertEquals("1. Kwesta%Khethile Khethile ft. @Makwa", testCaesarCipherDecoder.decodeUserText());
    }


}
