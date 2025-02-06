import java.util.Scanner;
// 2022, S1

public class Main {
    public static void main(String[] args) {
       
        // Create and initialize variables needed
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        int ways = 0;

        // Check which sums of 5s and 4s can make up value
        while (value >= 0) {
            if (value % 5 == 0) {
                ways += 1;
            }
            value -= 4;
        }


        // Output Result (Total Ways)
        System.out.println(ways);
    }
}
