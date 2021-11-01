package com.codewithdawson.whileloops;

import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(true){
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("quit"))
                break;
            System.out.println(input);
        }
    }
}
