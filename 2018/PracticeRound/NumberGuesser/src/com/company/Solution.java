package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numberOfTestcasesString = scanner.nextLine();
        int numberOfTestcases = Integer.parseInt(numberOfTestcasesString);

        for(int i = 0; i < numberOfTestcases; i++){
            String[] limits = scanner.nextLine().split(" ");

            int lowerLimit = Integer.parseInt(limits[0]) + 1;
            int upperLimit = Integer.parseInt(limits[1]);

            int maxNumberOfGuesses = Integer.parseInt(scanner.nextLine()); //not using this
            int guesses = 0; //not using this

            boolean found = false;

            while(!found){
                int guess = (lowerLimit + upperLimit)/2;
                System.out.println(guess);

                String answer = scanner.nextLine();

                if(answer.equals("CORRECT")){
                    found = true;
                }

                if(answer.equals("TOO_SMALL")){
                    lowerLimit = ++guess;
                }

                if(answer.equals("TOO_BIG")){
                    upperLimit = --guess;
                }
            }
        }
        System.exit(0);
    }
}
