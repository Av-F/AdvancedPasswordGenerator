import java.util.Scanner;
import java.util.Random;
public class AdvancedPasswordGen { 
    public static void main(String args []) {
        // Random number package to get the random numbers needed.
        Random rand = new Random();
        int insert;
        int passwordIndex = 0;
        // Ask the user for how long their password needs to be.
        System.out.println("How long do you want your password to be?");
        Scanner scanner = new Scanner(System.in);
    
        int len = scanner.nextInt();
        // Empty password array.
        char [] password = new char[len];
        // Create different arrays to hold upper and lowercase letters as well as numbers.
        char[] upper = {'Q','W','E','R','T','Y','U','I','O', 'P','A','S','D','F','G','H'
                        ,'J','K','L','Z','X','C','V','B','N','M'};
        
        char [] lower = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f',
                        'g','h','j','k','l','z','x','c','v','b','n','m'};

        char [] numbers = {'1','2','3','4','5','6','7','8','9','0'};
        
        char [] specialChars = {'`','~','!','@','#','$','%','^','&','*','(',')',
        '_','-','+','=','{','}','|','\\',':',';','\'','\"','<',',','>','.','?','/','[',']'};
        // lengths of all of the arrays. 
        int upsLen = upper.length;
        int lowsLen = lower.length;
        int numsLen = numbers.length;
        int specialLen = specialChars.length;
        // Ask the user how many of each possible type of character to put into their password.
        System.out.println("How many uppercase letters do you want in your password?");
        int ups = scanner.nextInt();
        System.out.println("How many lowercase letters do you want in your password?");
        int low = scanner.nextInt();
        System.out.println("How many numbers do you want in your password?");
        int nums = scanner.nextInt();
        System.out.println("How many special characters do you want in your password?");
        int spec = scanner.nextInt();
        // Throw an exception if the number of wanted combinations is greater than expected pass length 
    
        scanner.close();
    if(ups>0) {
        for(int i = 0; i < ups; i++) {
            insert = rand.nextInt(upsLen);
            password[passwordIndex] = upper[insert];
            passwordIndex++;
        }
    }
    if(low>0) {
        for(int i = 0; i < low; i++) {
            insert = rand.nextInt(lowsLen);
            password[passwordIndex] = lower[insert];
            passwordIndex++;
        }
    }
    if(nums>0) {
        for(int i = 0; i < nums; i++) {
            insert = rand.nextInt(numsLen);
            password[passwordIndex] = numbers[insert];
            passwordIndex++;
        }
    }
    if(spec>0) {
        for(int i = 0; i < spec; i++) {
            insert = rand.nextInt(specialLen);
            password[passwordIndex] = specialChars[insert];
            passwordIndex++;
        }
    }   
    // for loop to swap the array elements
    Random randy = new Random();
    for (int i = 0; i < password.length; i++) {
        int swap = randy.nextInt(password.length);
        char temp = password[swap];
        password[swap] = password[i];
        password[i] = temp;
    }
    
    System.out.print("Your password is: ");
    for(int i = 0; i < len; i++) {
        System.out.print(password[i]);
    }

}
}
