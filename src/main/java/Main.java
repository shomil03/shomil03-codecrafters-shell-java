import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        System.out.print("$ "); 

        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(true){
            String input[] = scanner.next().split(" ");
            // inputs.add(scanner.nextLine());

            switch (input[0]) {
                case "exit":
                    return;
                    // break;
                default:
                    System.out.println(String.valueOf(input)+": command not found");
                    break;
            }
            
            System.out.print("$ "); 
        }

        // for(String input : inputs) {
        //     System.out.println(input+": command not found");
        // }
        
    }
}
