import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        System.out.print("$ "); 

        Scanner scanner = new Scanner(System.in);
        // List<String> inputs = new ArrayList<>();
        while(true){
            String inputs = scanner.nextLine();
            String input[] = inputs.split(" ");
            // inputs.add(scanner.nextLine());

            switch (input[0].toLowerCase()) {
                
                case "exit":
                    return;
                    // break;

                case "echo":
                    System.out.println(inputs.substring(inputs.indexOf(" ")+1));
                    // System.out.println();
                    // for(int i = 1 ; i < input.length ; i++) {
                    //     System.out.print(input[i] +" ");
                    // }
                    // System.out.println();
                    break;
                default:
                    System.out.println(inputs+": command not found");
                    break;
            }
            
            System.out.print("$ "); 
        }

        // for(String input : inputs) {
        //     System.out.println(input+": command not found");
        // }
        
    }
}
