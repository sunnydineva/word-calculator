package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.print("Enter the calculation (e.g. twenty plus eleven): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


// define regular expression pattern to match operators (+, -, *, /)
        String operatorPattern = "plus|minus|times|divided by";

        String[] words = input.split(" ");

        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("", 0);
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("ten", 10);
        wordToNumber.put("eleven", 11);
        wordToNumber.put("twelve", 12);
        wordToNumber.put("thirteen", 13);
        wordToNumber.put("fourteen", 14);
        wordToNumber.put("fifteen", 15);
        wordToNumber.put("sixteen", 16);
        wordToNumber.put("seventeen", 17);
        wordToNumber.put("eighteen", 18);
        wordToNumber.put("nineteen", 19);
        wordToNumber.put("twenty", 20);
        wordToNumber.put("thirty", 30);
        wordToNumber.put("forty", 40);
        wordToNumber.put("fifty", 50);
        wordToNumber.put("sixty", 60);
        wordToNumber.put("seventy", 70);
        wordToNumber.put("eighty", 80);
        wordToNumber.put("ninety", 90);
        wordToNumber.put("hundred", 100);
        wordToNumber.put("thousand", 1000);
        wordToNumber.put("million", 1000000);

        Map<Integer, String> numberToWord = new HashMap<>();
        numberToWord.put(0, "");
        numberToWord.put(1, "one");
        numberToWord.put(2, "two");
        numberToWord.put(3, "three");
        numberToWord.put(4, "four");
        numberToWord.put(5, "five");
        numberToWord.put(6, "six");
        numberToWord.put(7, "seven");
        numberToWord.put(8, "eight");
        numberToWord.put(9, "nine");
        numberToWord.put(10, "ten");
        numberToWord.put(11, "eleven");
        numberToWord.put(12, "twelve");
        numberToWord.put(13, "thirteen");
        numberToWord.put(14, "fourteen");
        numberToWord.put(15, "fifteen");
        numberToWord.put(16, "sixteen");
        numberToWord.put(17, "seventeen");
        numberToWord.put(18, "eighteen");
        numberToWord.put(19, "nineteen");
        numberToWord.put(20, "twenty");
        numberToWord.put(30, "thirty");
        numberToWord.put(40, "forty");
        numberToWord.put(50, "fifty");
        numberToWord.put(60, "sixty");
        numberToWord.put(70, "seventy");
        numberToWord.put(80, "eighty");
        numberToWord.put(90, "ninety");
        numberToWord.put(100, "hundred");
        numberToWord.put(1000, "thousand");
        numberToWord.put(1000000, "million");
        numberToWord.put(1000000000, "billion");


// initialize numbers
        int num1 = 0;
        int num2 = 0;
        boolean isHundred = false;
        boolean isThousand = false;
        boolean isMillion = false;
        boolean isBillion = false;
        int operatorIndex = 0;
        String operator = "";
        StringBuilder sayResult = new StringBuilder();
        int result = 0;
// loop through words to find numbers & operator
        for (int i = words.length - 1; i >= 0; i--) {

            //check operator
            if (words[i].matches(operatorPattern)) {
                operatorIndex = i;
                operator = words[i];
            }

            // check if word is a number
            if (wordToNumber.containsKey(words[i])) {
                // convert word to number
                int number = wordToNumber.get(words[i]);

                if (number == 100) {
                    isHundred = true;
                    continue;
                } else if (number == 1000) {
                    isThousand = true;
                    continue;
                } else if (number == 10000000) {
                    isMillion = true;
                    continue;
                } else if (number == 1000000000) {
                    isBillion = true;
                    continue;
                }

                //checks witch number to increment
                if (i < operatorIndex) {
                    if (isHundred) {
                        num1 += (number * 100);
                        isHundred = false;
                    } else if (isThousand) {
                        num1 += (number * 1000);
                        isThousand = false;
                    } else if (isMillion) {
                        num1 += (number * 10000000);
                        isMillion = false;
                    } else if (isBillion) {
                        num1 += (number * 1000000000);
                        isBillion = false;
                    } else {
                        num1 += number;
                    }
                } else {
                    if (isHundred) {
                        num2 += (number * 100);
                        isHundred = false;
                    } else if (isThousand) {
                        num2 += (number * 1000);
                        isThousand = false;
                    } else if (isMillion) {
                        num2 += (number * 10000000);
                        isMillion = false;
                    } else if (isBillion) {
                        num2 += (number * 1000000000);
                        isBillion = false;
                    } else {
                        num2 += number;
                    }
                }
            }

            // calculate result based on operator
            switch (operator) {
                case "plus":
                    result = num1 + num2;
                    break;
                case "minus":
                    result = num1 - num2;
                    break;
                case "times":
                    result = num1 * num2;
                    break;
                case "divided by":
                    result = num1 / num2;
                    break;
            }


            sayResult = new StringBuilder();

            int remainder;
            int resultToBeManipulated = result;

            if (resultToBeManipulated >= 1000) {
                remainder = resultToBeManipulated / 1000;
                sayResult.append(numberToWord.get(remainder)).append(" ").append(numberToWord.get(1000)).append(" ");
                resultToBeManipulated %= 1000;
            }
            if (resultToBeManipulated >= 100) {
                remainder = resultToBeManipulated / 100;
                sayResult.append(numberToWord.get(remainder)).append(" ").append(numberToWord.get(100)).append(" ");
                resultToBeManipulated %= 100;
            }
            if (resultToBeManipulated >= 10) {
                remainder = resultToBeManipulated / 10;
                sayResult.append(numberToWord.get(remainder * 10)).append(" ");
                resultToBeManipulated %= 10;
            }
            if (resultToBeManipulated < 10) {
                sayResult.append(numberToWord.get(resultToBeManipulated)).append(" ");
            }
        }
        System.out.println("Num 1: " + num1);
        System.out.println("Operator: " + operator);
        System.out.println("Num 2: " + num2);
        System.out.println("Result: " + result);

        System.out.println(sayResult);
    }
}


