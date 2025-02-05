import java.util.Scanner;
// This is for 2022, S1

public class CCC {
    public static void main(String[] args) {
       
        // Create and initialize variables needed
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        int fourValue = value;
        int fiveValue = value;
        int mixedValue = value;
        int ways = 0;
        
        // How many fours until zero?
        while(fourValue > 0) {
            fourValue -= 4;
            if (fourValue == 0) {
                ways += 1;
            }
        }

         // How many fives until zero?
        while(fiveValue > 0) {
            fiveValue -= 5;
            if (fiveValue == 0) {
                ways += 1;
            }
        }

        // How many fours and fives until zero?
        while (mixedValue > 0) {
            if (mixedValue % 4 == 0) {
                mixedValue -= 4;
            } else {
                mixedValue -= 5;
            }
            if (mixedValue == 0) {
                ways += 1;
            }
        }


        // Output Result (Total Ways)
        System.out.println(ways);
    }
}
