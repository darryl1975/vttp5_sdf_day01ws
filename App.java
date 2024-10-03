import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
    
    public static void main(String[] args) {

        userInput();
    }

    public static void menu() {
        System.out.println("Welcome to your shopping cart");
        System.out.println(("============================="));
        System.out.println();
        System.out.println("List items in the cart: type 'list'");
        System.out.println("Add item(s) into the cart: type 'add xxx,,  ,,yyy,fgg'");
        System.out.println("Delete item from the cart: type 'delete 1'");
        System.out.println("Exit/Terminate program: type 'quit'");
    }

    public static void userInput() {

        List<String> cartItems = new ArrayList<>();
        // Set<String> cartItems = new HashSet<>();

        Console console = System.console();
        String keyboardInput = "";

        while (!keyboardInput.equals("quit")) {
            menu();

            keyboardInput = console.readLine(">>> ");
            keyboardInput = keyboardInput.toLowerCase();

            if (keyboardInput.equals("list")) {
                if (cartItems.size() > 0) {
                    for(String itm: cartItems) {
                        System.out.println("Item: " + itm);
                    }
                } else {
                    System.out.println("No item in cart...");
                }
            } 

            if (keyboardInput.startsWith("add")) {
                keyboardInput = keyboardInput.replace(',', ' ');

                Scanner scan = new Scanner(keyboardInput.substring(4));
                String tempStorage = "";
                while (scan.hasNext()) {
                    tempStorage = scan.next();
                    cartItems.add(tempStorage);
                }
                scan.close();
            }

            if (keyboardInput.startsWith("delete")) {
                Scanner scan = new Scanner(keyboardInput.substring(6));
                String deleteIndex = scan.next();
                scan.close();
                int indexToDelete = Integer.parseInt(deleteIndex) - 1;
                
                if (indexToDelete <= cartItems.size()) {
                    if (indexToDelete < 0) {
                        System.out.println("negative index position. Delete operation cancelled");
                    } else {
                        // perform the delete
                        cartItems.remove(indexToDelete);
                    }
                } else {
                    System.out.println("Index out of bound. Delete operation cancelled.");
                }
            }
        }

        System.out.println("See you again...");

    }
}