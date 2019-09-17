package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.print("> ");
            String input = scanner.nextLine();
            input = input.trim();
            if (input.equalsIgnoreCase("look")) {
                System.out.println("You look around.");
            } else if (input.equalsIgnoreCase("inventory")) {
                System.out.println("You are carrying nothing.");
                } else if (input.equalsIgnoreCase("dance")) {
                System.out.println("You dance around.");
            } else if (input.equalsIgnoreCase("jump")) {
                System.out.println("You jump in the air.");
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("Huh? I don't understand.");
            }
        }
    }
}

