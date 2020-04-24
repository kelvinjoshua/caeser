package models;

import models.CaesarCipherEncoder;
        import models.CaesarCipherDecoder;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean programRunning = true;


        CaesarCipherEncoder encoder = new CaesarCipherEncoder("", 0);
        CaesarCipherDecoder decoder = new CaesarCipherDecoder("", 0);

        while (programRunning) {
            System.out.println("I am a Caesar Cipher program. Choose one of the following options:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            try {
                String choice = bufferedReader.readLine();
                if(choice.equals("1")) {
                    System.out.println("Enter the text statement you want to be encrypted:");
                    String userInputText = bufferedReader.readLine();
                    System.out.println("Enter a number to be used as  key:");
                    String stringInputKey = bufferedReader.readLine();
                    int inputKey = Integer.parseInt(stringInputKey);
                    // The constructor is moved to the top of the program
                    // CaesarCipherEncoder caesarCipherEncoder=new CaesarCipherEncoder(userInputText,inputKey);
                    //Use the setter methods  in CaesarCipherEncoder.java to set the values
                    // entered by the user as values to be used
                    encoder.setUserText(userInputText);
                    encoder.setUserKey(inputKey);
                    String encodingResult = encoder.encryptUserText();
                    System.out.println("Encrytped Text: " + encodingResult);
                } else if (choice.equals("2")) {
                    System.out.println("Enter the statement that you want to be decrypted:");
                    String userInputText = bufferedReader.readLine();
                    System.out.println("Enter a number to be used as key:");
                    String stringInputKey = bufferedReader.readLine();
                    int inputKey = Integer.parseInt(stringInputKey);
                    decoder.setUserText(userInputText);
                    decoder.setUserKey(inputKey);
                    String decodingResult = decoder.decodeUserText();
                    System.out.println("Decrytped Text: " + decodingResult);
                } else if (choice.equals("3")) {
                    System.out.println("Exit");
                    programRunning = false;
                } else {
                    System.out.println("cannot recognise.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
