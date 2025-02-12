import java.util.Scanner;

// Problem 2022, S2
// Used a counting system to detect violations

public class S2_2022 {
    static Scanner input = new Scanner(System.in);

    // Initializes String arrays
    public static String[] initArray(int length) {
        String[] array = new String[length];
        input.nextLine(); 
        for(int i = 0; i < length; i++) {
            array[i] = input.nextLine();
        }
   
        return array;
    }

    public static void main(String[] args) {
        
        // Initialize the reused variables / objects
        int violations = 0;

        // Initialize the 3 arrays
        int length = input.nextInt();  
        String[] together = initArray(length);
       
        length = input.nextInt(); 
        String[] notTogether = initArray(length);

        length = input.nextInt();
        String[] groups = initArray(length);

        for (String group: groups) {

            // should be in the same group
            for (int i = 0; i < together.length; i++) {
                String sameGroup = together[i];
                String[] people = sameGroup.split(" ");
                int count = 0;
                for(String person: group.split(" ")) {
                    if (people.length > 1) {
                        for (String individual : people) {
                        if (individual.equals(person) && people.length == 2) {
                            count += 1;
                        }
                    }
                }
                }

                // only 1/2 people is a violation, its constraint is removed from the together array to avoid duplicates
                if (count == 1) {
                    violations += 1;
                    together[i] = "nil";
                }

            }

            // can't be in the same group
            for (int i = 0; i < notTogether.length; i++) {
                String notSame = notTogether[i];
                String[] people = notSame.split(" ");
                int count = 0;
                for(String samePerson: people) {
                    for (String person: group.split(" ")) {
                        if (person.equals(samePerson)) {
                            count += 1;
                        }
                    }
                }
                // if both people found in the same group = violation
                if (count == 2) {
                    violations += 1;
                   
                    notTogether[i] = "nil";
                }
            }
        }

        // Print total violations
        System.out.println(violations);

    }
}