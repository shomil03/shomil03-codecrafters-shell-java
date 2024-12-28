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

                case "cd":
                    handleCD(inputs);
                    break;

                case "pwd":
                    String currentPath = System.getProperty("user.dir");
                    System.out.println(currentPath);
                    break;

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
                    boolean flag = false;
                    for(String path : paths) {
                        Path fullPath = Path.of(path , input[0]);
                        if(Files.isRegularFile(fullPath)) {
                            Process p = Runtime.getRuntime().exec((fullPath+ inputs.substring(input[0].length())).toString().split(" "));
                            p.getInputStream().transferTo(System.out);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                    System.out.println(inputs+": command not found");
                    break;
            }
            
            System.out.print("$ "); 
        }

        // for(String input : inputs) {
        //     System.out.println(input+": command not found");
        // }
        
    }

    public static void handleCD(String input){
        String currentPath = System.getProperty("user.dir");
        String newPath = input.substring(2);
        if(System.setProperty(currentPath, newPath) == null){
            System.setProperty(newPath, currentPath);
            System.out.println(input +" No such file or directory");
        }
    }

    public static void handleType(String[] inputs) {
        // System.out.println(Arrays.toString(paths));

        List<String> builtins = new ArrayList<>();
            builtins.add("echo");
            builtins.add("exit");
            builtins.add("type");
            builtins.add("pwd");

        if(builtins.contains(inputs[1])){
            System.out.println(inputs[1] +" is a shell builtin");
            return;
        }
        for(String path : paths) {
            Path fullPath = Path.of(path , inputs[1]);
            if(Files.isRegularFile(fullPath)){
                System.out.println(inputs[1] +" is "+fullPath);
                return;
            }                
        }
        System.out.println(inputs[1] + ": not found");
    }
}
