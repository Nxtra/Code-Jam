package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static String inputFile = "input.txt";
    static String outputFile = "output.txt";
    static int currentCursorIndex;

    static ArrayList<String> dictionary = new ArrayList<>();

    public static void main(String... args){
        IOHelper.deleteIfExist(outputFile);//delete the outputfile if it already exists
        List<String> input = IOHelper.readLines(inputFile);
        int[] firstLineInputs = Arrays.asList(input.get(0).split(" "))
            .stream().map(s -> Integer.parseInt(s)).mapToInt(i -> i).toArray();
        currentCursorIndex++;

        int L = firstLineInputs[0];
        int D = firstLineInputs[1];
        int N = firstLineInputs[2];

        for(int i = 0; i < D; i++){
            dictionary.add(input.get(currentCursorIndex));
            currentCursorIndex++;
        }

        for(int i = 0; i < N; i++){
            String currentMessage = input.get(currentCursorIndex);
            int numberOfMatches = getNumberOfDictionaryOptions(currentMessage);
            IOHelper.writeLineToFile(outputFile, createAndFormatOutputString(i, numberOfMatches));
            currentCursorIndex++;
        }

    }

    private static int getNumberOfDictionaryOptions(String currentMessage) {
        currentMessage = currentMessage.replace("(","!(").replace(")",")!");
        String[] splittedMessage = currentMessage.split("!");
        ArrayList<String> regexParts = new ArrayList<>();
        for(String messagePart: splittedMessage){
            if(messagePart.startsWith("(")){
                messagePart = messagePart.substring(1,messagePart.length()-1);
                String regexPart = "(" + Arrays.asList(messagePart.split("")).stream().collect(Collectors.joining("|")) + ")";
                regexParts.add(regexPart);
            }else{
                regexParts.add(messagePart);
            }
        }
        String regex = "^" + String.join("", regexParts) + "$";

        int numberOfMatches = 0;
        for(String w: dictionary){
            if(w.matches(regex)){
                numberOfMatches++;
            }
        }

        return numberOfMatches;
    }

    private static String createAndFormatOutputString(int numberOfTestCase, int hits){
        return String.format("Case #%d: %d", numberOfTestCase+1, hits);
    }
}
