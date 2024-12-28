import java.util.Scanner;
import java.util.*;
public class Main {
    static String paths[] = null;
    public static void main(String[] args) throws Exception {
        // 
        if(args.length > 0 && args[0].substring(0 , 4).equals("PATH")){
            System.out.println(Arrays.toString(args));
            String path = args[0].substring(6 , args[0].length()-1);
            paths = path.split(":");
        }

        // Uncomment this block to pass the first stage
        System.out.print("$ "); 
        
        Scanner scanner = new Scanner(System.in);
        // List<String> inputs = new ArrayList<>();
        while(true){
            String inputs = scanner.nextLine();
            String input[] = inputs.split(" ");
            // inputs.add(scanner.nextLine());

            switch (input[0].toLowerCase()) {

                case "type":
                    handleType(input);
                    break;
                
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
    public static void handleType(String[] inputs) {
        // System.out.println(Arrays.toString(paths));
        switch (inputs[1]) {
            case "echo":
                System.out.println(inputs[1] +" is a shell builtin");
                break;
            case "exit":
                System.out.println(inputs[1] +" is a shell builtin");
                break;
            case "type":
                System.out.println(inputs[1] +" is a shell builtin");
                break;
            default:
                System.out.println(inputs[1] + ": not found");
                break;
        }
    }
}
