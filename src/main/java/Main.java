import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class Main {
    static String paths[] = null;
    public static void main(String[] args) throws Exception {
        paths = System.getenv("PATH").split(":");

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

                    for(String path : paths) {
                        Path fullPath = Path.of(path , input[0]);
                        if(Files.isRegularFile(fullPath)) {
                            Process p = Runtime.getRuntime().exec((fullPath+ inputs.substring(input[0].length())).toString().split(" "));
                            p.getInputStream().transferTo(System.out);
                            break;
                        }
                    }
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
            for(String path : paths) {
                Path fullPath = Path.of(path , inputs[1]);
                if(Files.isRegularFile(fullPath)){
                    System.out.println(inputs[1] +" is "+fullPath);
                    return;
                    }
                }
                System.out.println(inputs[1] + ": not found");
                break;
        }
    }
}
