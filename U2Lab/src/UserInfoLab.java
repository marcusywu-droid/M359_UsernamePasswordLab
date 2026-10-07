import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        String password;
        String username;
        String firstName;
        String lastName;
        boolean validPass;
        String credNum;

        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name below");
        firstName = scan.nextLine();
        System.out.println("Enter last name below");
        lastName = scan.nextLine();

        username = generateUsername(firstName, lastName);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter password below");
        password = scan.nextLine();
        validPass = validatePassword(password);

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if(validPass){
            System.out.println("Enter credit card number below");
            credNum = scan.nextLine();
            maskCreditCard(credNum);
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        String username = "";

//        first name portion
        for(int i = 0; i < 3; i++){
            String letter = "" + firstName.charAt(i);
            if(letter.equals(" ")){
                username += firstName.charAt(i);
            }
        }

//        last name portion
        for(int i = 0; i < 3; i++){
            String letter = "" + lastName.charAt(i);
            if(letter.equals(" ")){
                username += lastName.charAt(i);
            }
        }

            return username;
    }

    public static boolean validatePassword(String password) {
        if(password.length() >= 8){
//            so um look back at notes for this one cause i am NOT trying to do ts in class
        }
        return true;
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
