package sg.edu.nus.iss;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print("> ");
        input = scan.nextLine();
        String[] inputArray = input.split(" ");

        while (!inputArray[0].equalsIgnoreCase("exit")) {

            double num1 = Double.parseDouble(inputArray[0]);
            double num2 = Double.parseDouble(inputArray[2]);

            if (inputArray[1].equals("+")) {
                System.out.println(num1 + num2);
            } else if (inputArray[1].equals("-")) {
                System.out.println(num1 - num2);
            } else if (inputArray[1].equals("*")) {
                System.out.println(num1 * num2);
            } else if (inputArray[1].equals("/")) {                
                System.out.println(num1 / num2);
            } 

            System.out.print("> ");
            input = scan.nextLine();
            inputArray = input.split(" ");
        }

        System.out.println("Bye bye");

        scan.close();
    }
}
