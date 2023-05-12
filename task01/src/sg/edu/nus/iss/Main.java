package sg.edu.nus.iss;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String input;
        double $last = 0;

        System.out.print("> ");
        input = scan.nextLine();
        String[] inputArray = input.split(" ");

        while (!inputArray[0].equalsIgnoreCase("exit")) {

            double num1;
            double num2;

            // prepare first and second numbers for computation
            if (inputArray[0].trim().equals("$last")) {
                num1 = $last;
            } else {
                num1 = Double.parseDouble(inputArray[0]);
            }

            if (inputArray[2].trim().equals("$last")) {
                num2 = $last;
            } else {
                num2 = Double.parseDouble(inputArray[2]);
            }

            // compute base on operator entered
            if (inputArray[1].equals("+")) {
                $last = num1 + num2;
            } else if (inputArray[1].equals("-")) {
                $last = num1 - num2;
            } else if (inputArray[1].equals("*")) {
                $last = num1 * num2;
            } else if (inputArray[1].equals("/")) {  
                $last = num1 / num2;              
            } 

            // print out result and ask user for next input
            System.out.println($last);
            System.out.print("> ");
            input = scan.nextLine();
            inputArray = input.split(" ");
        }

        System.out.println("Bye bye");

        scan.close();
    }
}
