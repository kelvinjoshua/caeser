package models;

import java.util.ArrayList;
import java.util.List;
public class CaesarCipherDecoder {
    private CaesarCipherEncoder EncoderDetails = new CaesarCipherEncoder("", 0);

    private String userText;
    private int decodeKey;
    private List<String> decodedOutput = new ArrayList<String>();


    public CaesarCipherDecoder(String userText, int decodeKey) {
        this.userText = userText;
        this.decodeKey = decodeKey;
    }

    public String decodeUserText() {
        for (int i = 0; i < userText.length(); i++) {
            if (Character.isUpperCase(userText.charAt(i))) {
                int decodedValue = ((int)(userText.charAt(i)) + (26 - decodeKey) - 65) % 26 + 65;
                char decodedChar = (char)(decodedValue);
                String decodedString = Character.toString(decodedChar);
                decodedOutput.add(decodedString);
            } else if (Character.isLowerCase(userText.charAt(i))) {
                int decodedValue = ((int)(userText.charAt(i)) + (26 - decodeKey) - 97) % 26 + 97;
                char decodedChar = (char)(decodedValue);
                String decodedString = Character.toString(decodedChar);
                decodedOutput.add(decodedString);
            } else {
                String encodedString = Character.toString(userText.charAt(i));
                decodedOutput.add(encodedString);
            }
        }
        return String.join("", decodedOutput);
    }

    // Getter methods
    public String getUserText() {
        this.userText = EncoderDetails.getInputString();
        return this.userText;
    }

    public int getUserKey() {
        this.decodeKey = EncoderDetails.getShiftKey();
        return this.decodeKey;
    }

    // The two functions below are setter functions used to set user input from App.java as
    // properties of an instance of this class when the program is running. Use these setter
    // functions instead of the constructor to set the properties
    public String setUserText(String userInput) {
        return this.userText = userInput;
    }

    public int setUserKey(int userKey) {
        return this.decodeKey = userKey;
    }
}
