import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        String password;
        String username;
        String firstName;
        String lastName;
        boolean validPass;
        String credNum;
        String maskedCred = "";

        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        firstName = scan.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = scan.nextLine();

        username = generateUsername(firstName, lastName);

        System.out.println("Username: " + username + "\n");

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.print("Enter Password: ");
        password = scan.nextLine();
        validPass = validatePassword(password);

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if(validPass){
            System.out.println("Valid Password. Checking Credit Card Number\nEnter Credit Card Number: ");
            credNum = scan.nextLine();
            maskedCred = maskCreditCard(credNum);
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing
        if(maskedCred.contains("*")){
            System.out.println("\nFinal Details:\nUsername:\t" + username + "\nCredit Card: " + maskedCred);
        }
    }

    public static String generateUsername(String firstName, String lastName) {
        String username = "";

//        first name portion
        if(firstName.length() > 2) {
            for (int i = 0; i < 3; i++) {
                username += firstName.charAt(i);
            }
        }
        else{
            username += firstName;
        }

        if(lastName.length() > 2) {
//        last name portion
            for (int i = 0; i < 3; i++) {
                username += lastName.charAt(i);
            }
        }
        else{
            username += lastName;
        }
            return username.toLowerCase();
    }

    public static boolean validatePassword(String password) {
        boolean capCheck = false;
        boolean len = true;
        boolean dig = true;
        for(int i = 0; i < password.length(); i++){
            if (password.substring(i, i + 1).equals(password.substring(i, i + 1))){
                capCheck = true;
            }
        }
        if(!(password.length() >= 8)){
            System.out.println("Invalid, Too Short");
            len = false;
            if(!capCheck){
                System.out.println("Invalid, No Uppercase Letter");
                if(!containsDigit(password)){
                    dig = false;
                    System.out.println("Invalid, No Digit");
                }
            }
        }
        if(len && capCheck && dig){
            return true;
        }
        else {
            return false;
        }
    }

    public static String maskCreditCard(String creditCardNumber) {
        if(creditCardNumber.length() == 16){
            if(allDigits(creditCardNumber)){
                return "**** **** ****" + creditCardNumber.substring(12);
            }
        }
        return "N/A";
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
