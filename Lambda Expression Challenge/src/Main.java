import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;

import static java.util.List.*;

public class Main {
    public static void main(String[] args) {
        //Use the two methods you've made, perform the following functions on the elements in the array with appropriate
        //lambda expression
        //1: Transform names to all uppercase
        //2: Add a randomly generated middle initial and include a period
        //3: Add a last name that is the reverse of the first name
        //4: print your array or the array elements after each change using the forEach method at lease once
        //5: Create a new modifiable ArrayList from your names array removing any names where the last name = the first

        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Hannah", "Isaac", "Anna"};

        //Solution 1:
        setAll(names, i -> names[i].toUpperCase());
        Arrays.asList(names).forEach(s -> System.out.println("Solution 1: Transform names to all uppercase: " + s));


        //Solution 2:
        setAll(names, i -> {
            Random random = new Random();
            int randomNumber = random.nextInt(26);  // Generate a random number between 0 and 25
            char middleInitial = (char) ('A' + randomNumber);  // Convert the random number to a character in the range 'A' to 'Z'
            return names[i].concat(" " + middleInitial + ".");
        });

        Arrays.asList(names).forEach(s -> System.out.println("Solution 2: " + s));

        //Solution 2 v2 using a method to generate random char:
        String[] names2 = {"Alice", "Bob", "Charlie", "David", "Eve", "Hannah", "Isaac", "Anna"};

        List<String> backedByArray = Arrays.asList(names2);
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'Z'));
        System.out.println("Solution 2 V2: " + Arrays.toString(names2));



        //Solution 3: Add a last name that is the reverse of the first name
        setAll(names, i -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : names[i].toCharArray()) {
                if (c == ' ') {
                    break;
                }
                stringBuilder.append(c);
            }
            return names[i] + " " + stringBuilder.reverse();
        });

        Arrays.asList(names).forEach(s -> System.out.println("Solution 3: " + s));

        //Solution 5:
        List<String> nameList = new ArrayList<>(of(names));
        nameList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));

        nameList.forEach(s -> System.out.println("Solution 5: " + s));
    }

    //Make a setAllArray
    public static void setAll(String[] array, IntFunction<String> modifier) {
        Arrays.setAll(array, i -> modifier.apply(i));

    }
    //Make a replaceAll method
    public static <T> T replaceAll(T operand1, T operand2, BinaryOperator<T> operator) {
        return operator.apply(operand1, operand2);
    }

    public static char getRandomChar(char startChar, char endChar) {
        Random random = new Random();
        return (char) random.nextInt((int) startChar, (int) endChar +1);
    }




}