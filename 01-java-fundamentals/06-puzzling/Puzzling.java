import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Puzzling {
    // getTenRolls
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> myRandomArray = new ArrayList<Integer>();
        Random rand = new Random();
        Byte[] mybytes=new Byte[5];

       // create random object
      Random randomno = new Random();

      // create byte array
      byte[] nbyte = new byte[5];

      // put the next byte in the array
      randomno.nextBytes(nbyte);

      // check the value of array   
      System.out.println("Value of byte array: " +Arrays.toString(nbyte));
        for (int i = 1; i <= 10; i++) {
            myRandomArray.add(rand.nextInt(20));
        }

        return myRandomArray;
    }

    public String getRandomLetterWithArray() {
        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        return alphabet[rand.nextInt(26)];
    }

    // Possible solution without array
    public String getRandomLetter() {

        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabetString.charAt(rand.nextInt(26));

        return String.valueOf(randomChar);
    }

    // generatePassword
    
    public String generatePassword() {

        String password = "";

        for (int i = 0; i < 8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }

    // getNewPasswordSet
    
    public ArrayList<String> getNewPasswordSet(int length) {

        ArrayList<String> passwordSet = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;

    }

}
