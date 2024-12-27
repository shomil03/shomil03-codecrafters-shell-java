import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        System.out.print("$ "); 

        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(true){
            String input = scanner.next();
            // inputs.add(scanner.nextLine());
            System.out.println(input+": command not found");
            System.out.print("$ "); 
        }

        // for(String input : inputs) {
        //     System.out.println(input+": command not found");
        // }
        
    }
}
